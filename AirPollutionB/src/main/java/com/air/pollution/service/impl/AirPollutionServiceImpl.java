package com.air.pollution.service.impl;

import com.air.pollution.converter.AirPollutionConverter;
import com.air.pollution.dto.SearchResponseDto;
import com.air.pollution.entity.AirPollutionEntity;
import com.air.pollution.entity.City;
import com.air.pollution.entity.Component;
import com.air.pollution.pojo.response.AirPollutionResponse;
import com.air.pollution.pojo.response.CityResponse;
import com.air.pollution.pojo.response.Components;
import com.air.pollution.pojo.response.ResponseList;
import com.air.pollution.repository.CityAirPollutionRepository;
import com.air.pollution.repository.CityRepository;
import com.air.pollution.service.AirPollutionService;
import com.air.pollution.service.OpenWeatherService;
import com.air.pollution.util.AQICategoryBreakPointUtil;
import com.air.pollution.util.DateUtil;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AirPollutionServiceImpl implements AirPollutionService {

    private static final Logger LOG = LogManager.getLogger(AirPollutionServiceImpl.class);

    private final CityAirPollutionRepository cityAirPollutionRepository;
    private final OpenWeatherService openWeatherService;
    private final CityRepository cityRepository;

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    @Override
    public SearchResponseDto getAirPollutionsBySearchParams(String city, String startDate, String endDate) {
        Optional<City> cityOptional = cityRepository.findByNameIgnoreCase(city);

        if (!cityOptional.isPresent()) {
            addCity(city);
            cityOptional = cityRepository.findByNameIgnoreCase(city);
        }


        Integer start;
        Integer end;
        if ("".equals(startDate)) {
            if ("".equals(endDate)) {
                LocalDateTime endLocalDate = DateUtil.getCurrentLocalDate().atStartOfDay();
                LocalDateTime startLocalDate = DateUtil.minusDay(endLocalDate.toLocalDate(), 6).atStartOfDay();

                LOG.info("Start and end date parameters are empty, default values will be applied");

                start = Math.toIntExact(startLocalDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() / 1000);
                end = Math.toIntExact(endLocalDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() / 1000);
                startDate = startLocalDate.format(DateTimeFormatter.ofPattern(DateUtil.YYYY_MM_DD));
                endDate = endLocalDate.format(DateTimeFormatter.ofPattern(DateUtil.YYYY_MM_DD));

            } else {
                LocalDate startLocalDate = DateUtil.dateToLocalDate(DateUtil.stringDateToDate(endDate));
                LocalDateTime startLocalDateTime = DateUtil.minusDay(startLocalDate, 6).atStartOfDay();
                startDate = startLocalDateTime.format(DateTimeFormatter.ofPattern(DateUtil.YYYY_MM_DD));
                start = Math.toIntExact(startLocalDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() / 1000);
                end = DateUtil.stringDateToUnixDate(endDate);
            }
        } else {
            if ("".equals(endDate)) {
                LocalDate endLocalDate = DateUtil.dateToLocalDate(DateUtil.stringDateToDate(startDate));
                LocalDateTime endLocalDateTime = DateUtil.addDay(endLocalDate, 6).atStartOfDay();
                endDate = endLocalDateTime.format(DateTimeFormatter.ofPattern(DateUtil.YYYY_MM_DD));
                end = Math.toIntExact(endLocalDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() / 1000);
                start = DateUtil.stringDateToUnixDate(startDate);
            } else {
                start = DateUtil.stringDateToUnixDate(startDate);
                end = DateUtil.stringDateToUnixDate(endDate);
            }
        }


        List<AirPollutionEntity> list = cityAirPollutionRepository.
                findCityAirPollutionEntitiesByCityAndUnixDateBetween(city,
                        start - 1,
                        end + 1).get();

        Collections.sort(list);
        List<LocalDate> dates = DateUtil.datesFromToDate(startDate, endDate);

        List<LocalDate> dbDateList = dbDates(list);
        List<LocalDate> apiDateList = getDifferences(dates, dbDateList);
        List<String> dbLog = DateUtil.logDates(dbDateList);
        List<String> apiLog = DateUtil.logDates(apiDateList);

        dbLog.forEach(x -> LOG.info(x + " data will be retrieved from database."));
        apiLog.forEach(x -> LOG.info(x + " data will be retrieved from API and saved in database"));


        for (LocalDate localDate : apiDateList) {
            LocalDateTime startOfDay = localDate.atStartOfDay();
            LocalDateTime endOfDay = LocalTime.MAX.atDate(localDate);
            ZonedDateTime endDateZoned = endOfDay.toLocalDate().atTime(LocalTime.MAX)
                    .atZone(ZoneId.systemDefault());
            Integer startDateStamp = Math.toIntExact(startOfDay.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() / 1000);
            Integer endDateStamp = Math.toIntExact(endDateZoned.toInstant().getEpochSecond());


            AirPollutionResponse response =
                    openWeatherService.getAirPollutionByCityAndBetweenTwoDates(cityOptional.get(), startDateStamp, endDateStamp);


            if (Objects.nonNull(response) && !CollectionUtils.isEmpty(response.getList())) {

                ResponseList x = response.getList().get(0);
                Components components = x.getComponents();
                Component component = Component.builder()
                        .co(components.getCo())
                        .coAQICategory(AQICategoryBreakPointUtil.findCOCategory(components.getCo()))
                        .so2(components.getSo2())
                        .so2aQICategory(AQICategoryBreakPointUtil.findSO2Category(components.getSo2()))
                        .o3(components.getO3())
                        .o3AQICategory(AQICategoryBreakPointUtil.findO3Category(components.getO3()))
                        .build();

                AirPollutionEntity entity = AirPollutionEntity.builder()
                        .city(city)
                        .components(component)
                        .date(DateUtil.unixDateToFormattedDate(x.getDt()))
                        .unixDate(x.getDt())
                        .build();

                try {
                    cityAirPollutionRepository.save(entity);
                } catch (Exception e) {
                    LOG.error("Error received while registering Air Pollution presence : " + e.getMessage());
                }
                list.add(entity);
            }

        }

        return AirPollutionConverter.airPollutionEntityToDto(list);
    }

    @Override
    public void addCity(String cityName) {
        CityResponse[] cityResponses = openWeatherService.getCityInformation(cityName);
        if (cityResponses != null) {
            List<CityResponse> cityResponseList = Arrays.asList(cityResponses);
            if (CollectionUtils.isEmpty(cityResponseList)) {
                return;
            }
            CityResponse cityResponse = cityResponseList.stream().findFirst().get();
            City city = City.builder()
                    .lat(String.valueOf(cityResponse.getLat()))
                    .lon(String.valueOf(cityResponse.getLon()))
                    .country(cityResponse.getCountry())
                    .name(cityResponse.getName())
                    .build();
            cityRepository.save(city);
        }
    }

    @Override
    public void deleteAirPollution(String id) {
        LOG.info("Delete Air Pollution by id " + id);
        try {
            cityAirPollutionRepository.deleteById(id);
        } catch (Exception e) {
            LOG.error("Entity not deleted by id:" + id + " errorMessage: " + e.getMessage());
        }
    }

    private List<LocalDate> dbDates(List<AirPollutionEntity> list) {
        return list.stream().filter(distinctByKey(AirPollutionEntity::getDate))
                .map(x -> DateUtil.stringDateToDate(x.getDate())).collect(Collectors.toList())
                .stream().map(DateUtil::dateToLocalDate).collect(Collectors.toList());
    }

    private List<LocalDate> getDifferences(List<LocalDate> allDates, List<LocalDate> dbDates) {
        return allDates.stream().filter(x -> !dbDates.contains(x)).collect(Collectors.toList());
    }
}
