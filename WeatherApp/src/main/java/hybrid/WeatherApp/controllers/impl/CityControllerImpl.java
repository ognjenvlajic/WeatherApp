package hybrid.WeatherApp.controllers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hybrid.WeatherApp.controllers.CityController;
import hybrid.WeatherApp.dto.ForecastCityDTO;
import hybrid.WeatherApp.models.City;
import hybrid.WeatherApp.services.CityService;

@RestController
@RequestMapping(value = "/api/cities")
public class CityControllerImpl implements CityController {

	private final CityService cityService;

	@Autowired
	public CityControllerImpl(CityService cityService) {
		this.cityService = cityService;
	}

	@Override
	@GetMapping
	public ResponseEntity<?> getAvailableCities() {
		List<City> cities = this.cityService.findAll();
		List<ForecastCityDTO> retVal = new ArrayList<ForecastCityDTO>();
		cities.forEach(city -> retVal.add(new ForecastCityDTO(city)));
		HttpStatus status = retVal.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
		return new ResponseEntity<List<ForecastCityDTO>>(retVal, status);
	}

}
