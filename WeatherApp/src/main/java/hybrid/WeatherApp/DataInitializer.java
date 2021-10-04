package hybrid.WeatherApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import hybrid.WeatherApp.dto.ForecastDTO;
import hybrid.WeatherApp.models.City;
import hybrid.WeatherApp.services.CityService;
import hybrid.WeatherApp.services.OpenWeatherApiService;
import hybrid.WeatherApp.services.WeatherForecastService;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class DataInitializer implements ApplicationRunner {

	@Value("#{'${cities}'.split(';')}")
	private List<String> cities;

	private final CityService cityService;
	private final OpenWeatherApiService openWeatherApiService;
	private final WeatherForecastService weatherForecastService;

	@Autowired
	public DataInitializer(CityService cityService, OpenWeatherApiService openWeatherApiService,
			WeatherForecastService weatherForecastService) {
		this.cityService = cityService;
		this.openWeatherApiService = openWeatherApiService;
		this.weatherForecastService = weatherForecastService;
	}

    /**
     * Method reads cities from configuration file and fetch data from OpenWeatherMap API for those cities 
     *
     */
	public void run(ApplicationArguments args) throws Exception {
		this.cities.forEach(cityInfo -> {
			Mono<ForecastDTO> forecastData = this.openWeatherApiService.getCityForecastData(cityInfo);
			forecastData.subscribe(forecast -> {
				City city = this.cityService.saveCity(new City(forecast.getCity()));
				this.weatherForecastService.saveForcastData(forecast, city);
				log.info("City and forcast data are successfully added");
			}, error -> log.info("City {} is not found", cityInfo));
		});
	}
}
