package com.air.pollution.pojo.response;

import lombok.Data;

import java.util.List;

@Data
public class Response {
    private List<CityResponse> cityList;
}
