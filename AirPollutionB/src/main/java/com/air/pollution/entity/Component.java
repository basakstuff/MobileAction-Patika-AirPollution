package com.air.pollution.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Component {
    private Double co;
    private String coAQICategory;
    private Double o3;
    private String o3AQICategory;
    private Double so2;
    private String so2aQICategory;
}
