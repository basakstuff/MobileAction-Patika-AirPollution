package com.air.pollution.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SearchResponseDto {
    private String city;
    private List<ResultDto> result;
}
