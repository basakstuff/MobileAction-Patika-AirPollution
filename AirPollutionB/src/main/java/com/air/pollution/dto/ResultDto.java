package com.air.pollution.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultDto {
    private String id;
    private String date;
    private CategoryDto categories;
}
