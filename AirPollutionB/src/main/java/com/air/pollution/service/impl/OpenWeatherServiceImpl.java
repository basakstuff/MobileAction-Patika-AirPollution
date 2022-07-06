package com.air.pollution.service.impl;

import com.air.pollution.entity.City;
import com.air.pollution.pojo.response.AirPollutionResponse;
import com.air.pollution.pojo.response.CityResponse;
import com.air.pollution.service.OpenWeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherServiceImpl implements OpenWeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.city.base.url}")
    private String cityBaseUrl;

    @Value("${weather.api.air.base.url}")
    private String airBaseUrl;


    @Override
    public CityResponse[] getCityInformation(String cityName) {
        String url = cityBaseUrl + "/direct?q=" + cityName.toLowerCase() + "&limit=5&appid=" + apiKey;
        return restTemplate().getForObject(url, CityResponse[].class);
    }

    @Override
    public AirPollutionResponse getAirPollutionByCityAndBetweenTwoDates(City city, Integer startDateUnix, Integer endDateUnix) {
        String url = airBaseUrl + "/history?lat=" + city.getLat() + "&lon=" + city.getLon() + "&start=" + startDateUnix + "&end=" + endDateUnix + "&appid=" + apiKey;
        return restTemplate().getForObject(url, AirPollutionResponse.class);
    }

    private RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
