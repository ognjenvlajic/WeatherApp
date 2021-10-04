package hybrid.WeatherApp.services;

import hybrid.WeatherApp.dto.ForecastDTO;
import reactor.core.publisher.Mono;

public interface OpenWeatherApiService {
	
    /**
     * Method returns forecast data for forwarded city
     *
     * @param cityInfo - City info in format "name,country"
     * @return - Mono with forecast data
     */
	public Mono<ForecastDTO> getCityForecastData(String cityInfo);
	
}
