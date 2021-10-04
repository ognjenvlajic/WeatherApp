package hybrid.WeatherApp.services;

import java.time.Instant;
import java.util.List;

import hybrid.WeatherApp.dto.CityAverageTempDTO;
import hybrid.WeatherApp.dto.ForecastDTO;
import hybrid.WeatherApp.models.City;

public interface WeatherForecastService {
	
    /**
     * Method saves forecast data for forwarded city
     *
     * @param forecastDTO - DTO with fetched forecast data
     * @param city - City for which forecast data is fetched
     * @return - Mono with forecast data
     */
	public void saveForcastData(ForecastDTO forecastDTO, City city);
	
    /**
     * Method returns sorted average temperatures for forwarded cities in defined interval
     *
     * @param cities - List of city names for which we need to calculate average temperature
     * @param fromDate - The beginning of date interval from which average temperature is calculated
     * @param toDate - The end of date interval to which average temperature is calculated
     * @param sortAsc - Flag which indicate whether average temperatures should be sorted in ascending order 
     * @return - Sorted List of DTO with avarage temperatures for all forwarded cities
     */
	public List<CityAverageTempDTO> getAverageTemperatures(List<String> cities, Instant fromDate, Instant toDate, Boolean sortAsc);

}
