package com.air.pollution;

import com.air.pollution.api.CityController;
import com.air.pollution.entity.City;
import com.air.pollution.repository.CityRepository;
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
public class CityControllerTests {

    @Autowired
    private CityController cityController;

    @Mock
    private CityRepository cityRepository;

    @Test
    public void testAdd() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(cityRepository.save(any(City.class)));

        City city = new City("zip", "name", "lat", "lon", "country");
        ResponseEntity<City> responseEntity = cityController.addCity(city);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(202);
        assertThat(responseEntity.getHeaders().getLocation());
    }
}
