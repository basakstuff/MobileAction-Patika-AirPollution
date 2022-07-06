package com.air.pollution.api;


import com.air.pollution.dto.SearchResponseDto;
import com.air.pollution.service.AirPollutionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/air-pollution/")
@CrossOrigin(origins = "http://localhost:3000")
public class SearchController {

    private final AirPollutionService airPollutionService;

    @GetMapping("search")
    public ResponseEntity<SearchResponseDto> search(@RequestParam(value = "city", required = true) String city,
                                                    @RequestParam(value = "startDate") String startDate,
                                                    @RequestParam(value = "endDate") String endDate) {
        return new ResponseEntity<>(airPollutionService.getAirPollutionsBySearchParams(city, startDate, endDate), HttpStatus.ACCEPTED);
    }

    @GetMapping("delete")
    public ResponseEntity<Void> delete(@RequestParam(value = "id") String id) {
        airPollutionService.deleteAirPollution(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }
}
