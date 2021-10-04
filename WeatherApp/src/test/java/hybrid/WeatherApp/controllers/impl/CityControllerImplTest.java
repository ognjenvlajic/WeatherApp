package hybrid.WeatherApp.controllers.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hybrid.WeatherApp.models.City;
import hybrid.WeatherApp.services.CityService;

@RunWith(SpringJUnit4ClassRunner.class)
public class CityControllerImplTest {

	@Mock
	private CityService cityService;

	@InjectMocks
	private CityControllerImpl cityControllerImpl;

	@Test
	public void getAvailableCities_Should_ReturnEmptyList() {
		ResponseEntity<?> responseEntity = cityControllerImpl.getAvailableCities();

		verify(cityService, Mockito.times(1)).findAll();
		assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
	}

	@Test
	public void getAvailableCities_Should_ReturnList() {
		when(cityService.findAll()).thenReturn(Arrays.asList(City.builder().build()));

		ResponseEntity<?> responseEntity = cityControllerImpl.getAvailableCities();

		verify(cityService, Mockito.times(1)).findAll();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

}
