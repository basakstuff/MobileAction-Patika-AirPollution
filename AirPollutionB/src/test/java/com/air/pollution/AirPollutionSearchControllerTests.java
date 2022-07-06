package com.air.pollution;

import com.air.pollution.api.SearchController;
import com.air.pollution.dto.SearchResponseDto;
import com.air.pollution.entity.AirPollutionEntity;
import com.air.pollution.entity.Component;
import com.air.pollution.repository.CityAirPollutionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class AirPollutionSearchControllerTests {


    @Autowired
    private SearchController searchController;
    @Mock
    private CityAirPollutionRepository cityAirPollutionRepository;

    @Test
    public void testSearch() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(cityAirPollutionRepository.save(any(AirPollutionEntity.class)));

        AirPollutionEntity airPollutionEntity = new AirPollutionEntity("id", "city", new Component(), "howtodoinjava@gmail.com", 1520);
        ResponseEntity<SearchResponseDto> responseEntity = searchController.search("ankara", "2022-06-06", "2022-06-10");

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(202);
        assertThat(responseEntity.getHeaders().getLocation());
    }

}
