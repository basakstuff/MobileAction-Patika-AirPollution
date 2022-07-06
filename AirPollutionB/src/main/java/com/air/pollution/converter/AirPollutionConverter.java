package com.air.pollution.converter;


import com.air.pollution.dto.CategoryDto;
import com.air.pollution.dto.ResultDto;
import com.air.pollution.dto.SearchResponseDto;
import com.air.pollution.entity.AirPollutionEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AirPollutionConverter {

    public static SearchResponseDto airPollutionEntityToDto(List<AirPollutionEntity> airPollutionEntities) {
        List<ResultDto> result = new ArrayList<>();
        Collections.sort(airPollutionEntities);
        for (AirPollutionEntity airPollutionEntity : airPollutionEntities) {
            CategoryDto categoryDto = CategoryDto.builder()
                    .O3(airPollutionEntity.getComponents().getO3AQICategory())
                    .CO(airPollutionEntity.getComponents().getCoAQICategory())
                    .SO2(airPollutionEntity.getComponents().getSo2aQICategory()).build();
            result.add(ResultDto.builder().date(airPollutionEntity.getDate())
                    .id(airPollutionEntity.getId())
                    .categories(categoryDto).build());
        }

        return SearchResponseDto.builder()
                .city(airPollutionEntities.get(0).getCity())
                .result(result).build();
    }
}
