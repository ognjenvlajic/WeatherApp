package hybrid.WeatherApp.controllers.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hybrid.WeatherApp.dto.CityAverageTempDTO;
import hybrid.WeatherApp.services.WeatherForecastService;

@RunWith(SpringJUnit4ClassRunner.class)
public class WeatherForecastControllerImplTest {

	public final List<String> TEST_CITIES = new ArrayList<String>();
	public final Instant TEST_DATE_FROM = Instant.now();
	public final Instant TEST_DATE_TO = Instant.parse("2020-10-20T00:00:30Z");
	public final Boolean TEST_SORT_ASC = Boolean.TRUE;

	@Mock
	private WeatherForecastService weatherForecastService;

	@InjectMocks
	private WeatherForecastControllerImpl weatherForecastControllerImpl;

	@Test
	public void getAvailableCities_Should_ReturnEmptyList() {
		ResponseEntity<?> responseEntity = weatherForecastControllerImpl.getAverageTemperatures(TEST_CITIES,
				TEST_DATE_FROM, TEST_DATE_TO, TEST_SORT_ASC);

		verify(weatherForecastService, Mockito.times(1)).getAverageTemperatures(TEST_CITIES, TEST_DATE_FROM,
				TEST_DATE_TO, TEST_SORT_ASC);
		assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
	}

	@Test
	public void getAvailableCities_Should_ReturnList() {
		when(weatherForecastService.getAverageTemperatures(TEST_CITIES, TEST_DATE_FROM, TEST_DATE_TO, TEST_SORT_ASC))
				.thenReturn(Arrays.asList(CityAverageTempDTO.builder().build()));

		ResponseEntity<?> responseEntity = weatherForecastControllerImpl.getAverageTemperatures(TEST_CITIES,
				TEST_DATE_FROM, TEST_DATE_TO, TEST_SORT_ASC);

		verify(weatherForecastService, Mockito.times(1)).getAverageTemperatures(TEST_CITIES, TEST_DATE_FROM,
				TEST_DATE_TO, TEST_SORT_ASC);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

}
