package hybrid.WeatherApp.services.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hybrid.WeatherApp.dto.CityAverageTempDTO;
import hybrid.WeatherApp.models.City;
import hybrid.WeatherApp.repositories.WeatherForecastRepositorty;
import hybrid.WeatherApp.services.CityService;

@RunWith(SpringJUnit4ClassRunner.class)
public class WeatherForcastServiceImplTest {

	public final City TEST_CITY = City.builder().id(1L).name("Amsterdam").country("NL").build();
	public final City TEST_CITY_2 = City.builder().id(1L).name("Belgrade").country("RS").build();
	public final List<String> TEST_CITIES = Arrays.asList("Amsterdam", "Belgrade");
	public final Instant TEST_DATE_FROM = Instant.now();
	public final Instant TEST_DATE_TO = Instant.parse("2020-10-20T00:00:30Z");
	public final Boolean TEST_SORT_ASC = Boolean.TRUE;
	
	@Mock
	private WeatherForecastRepositorty weatherForecastReposistory;
	@Mock
	private CityService cityService;

	@InjectMocks
	private WeatherForecastServiceImpl weatherForecastServiceImpl;
	
	@Test
	public void getAverageTemperatures_Should_ReturnListOfTemperatures() {
		when(cityService.findAll()).thenReturn(Arrays.asList(TEST_CITY, TEST_CITY_2));
		when(weatherForecastReposistory.getAvgTempForCity(TEST_CITY, TEST_DATE_FROM, TEST_DATE_TO)).thenReturn(10.0);
		when(weatherForecastReposistory.getAvgTempForCity(TEST_CITY_2, TEST_DATE_FROM, TEST_DATE_TO)).thenReturn(15.2);
		
		List<CityAverageTempDTO> avgTemp = weatherForecastServiceImpl.getAverageTemperatures(null, TEST_DATE_FROM,
				TEST_DATE_TO, TEST_SORT_ASC);
		verify(cityService, Mockito.times(1)).findAll();
		verify(weatherForecastReposistory, Mockito.times(1)).getAvgTempForCity(TEST_CITY, TEST_DATE_FROM, TEST_DATE_TO);
		verify(weatherForecastReposistory, Mockito.times(1)).getAvgTempForCity(TEST_CITY_2, TEST_DATE_FROM, TEST_DATE_TO);
		
		assertNotNull(avgTemp);
		assertTrue(avgTemp.size() == 2);
	}
	
}
