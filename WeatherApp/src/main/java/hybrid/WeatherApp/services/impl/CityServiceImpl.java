package hybrid.WeatherApp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hybrid.WeatherApp.models.City;
import hybrid.WeatherApp.repositories.CityRepository;
import hybrid.WeatherApp.services.CityService;

@Service
public class CityServiceImpl implements CityService {
	
	private final CityRepository cityRepository;
	
	@Autowired
	public CityServiceImpl(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
	
	@Override
	public List<City> findAll() {
		return this.cityRepository.findAll();
	}

	@Override
	public List<City> findByNames(List<String> cityNames) {
		return this.cityRepository.findByNameIn(cityNames);
	}

	@Override
	public City saveCity(City city) {
		return this.cityRepository.save(city);
	}

}
