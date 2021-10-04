package hybrid.WeatherApp.services.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hybrid.WeatherApp.dto.CityAverageTempDTO;
import hybrid.WeatherApp.dto.ForecastCityDTO;
import hybrid.WeatherApp.dto.ForecastDTO;
import hybrid.WeatherApp.models.City;
import hybrid.WeatherApp.models.WeatherForecast;
import hybrid.WeatherApp.repositories.WeatherForecastRepositorty;
import hybrid.WeatherApp.services.CityService;
import hybrid.WeatherApp.services.WeatherForecastService;

@Service
public class WeatherForecastServiceImpl implements WeatherForecastService {

	private final WeatherForecastRepositorty weatherForecastReposistory;
	private final CityService cityService;

	@Autowired
	public WeatherForecastServiceImpl(WeatherForecastRepositorty weatherForecastRepositorty, CityService cityService) {
		this.weatherForecastReposistory = weatherForecastRepositorty;
		this.cityService = cityService;
	}

	public void saveForcastData(ForecastDTO forecastDTO, City city) {
		forecastDTO.getList().forEach(listElement -> 
			this.weatherForecastReposistory.save(new WeatherForecast(listElement.getDt(), listElement.getMain().getTemp(), city))
		);
	}

	@Override
	public List<CityAverageTempDTO> getAverageTemperatures(List<String> cities, Instant fromDate, Instant toDate, Boolean sortAsc) {
		List<City> citiesList = cities == null ? this.cityService.findAll() : this.cityService.findByNames(cities);
		List<CityAverageTempDTO> avgTemps = new ArrayList<CityAverageTempDTO>();
		citiesList.forEach(city -> {
			Double avgTemp = this.weatherForecastReposistory.getAvgTempForCity(city, fromDate, toDate);
			avgTemps.add(new CityAverageTempDTO(new ForecastCityDTO(city), avgTemp));
		});
		if (sortAsc == true) {
			Collections.sort(avgTemps, Comparator.comparing(CityAverageTempDTO::getAvgTemp));
		} else {
			Collections.sort(avgTemps, Comparator.comparing(CityAverageTempDTO::getAvgTemp).reversed());
		}
		return avgTemps;
	}

}
