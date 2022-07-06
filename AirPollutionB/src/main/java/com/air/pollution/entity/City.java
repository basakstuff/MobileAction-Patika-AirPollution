package com.air.pollution.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
public class City {

    private String zip;
    private String name;
    private String lat;
    private String lon;
    private String country;
}
