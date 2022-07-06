package com.air.pollution.repository;

import com.air.pollution.entity.AirPollutionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityAirPollutionRepository extends MongoRepository<AirPollutionEntity, String> {
    Optional<List<AirPollutionEntity>> findCityAirPollutionEntitiesByCityAndUnixDateBetween(String city, Integer fromUnixDate, Integer toUnixDate);
}
