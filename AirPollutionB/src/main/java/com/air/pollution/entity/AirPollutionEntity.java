package com.air.pollution.entity;

import lombok.*;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;


@Data
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@CompoundIndex(name = "city_unixDate", def = "{'city' : 1, 'unixDate': 1}", unique = true)
@Document
public class AirPollutionEntity implements Comparable<AirPollutionEntity> {

    @Id
    private String id;
    @Field("city")
    private String city;
    private Component components;
    private String date;
    @Field("unixDate")
    private Integer unixDate;

    @Override
    public int compareTo(AirPollutionEntity o) {
        return Integer.compare(unixDate, o.getUnixDate());
    }
}
