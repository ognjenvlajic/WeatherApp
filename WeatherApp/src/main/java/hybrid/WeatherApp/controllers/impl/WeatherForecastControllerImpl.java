package hybrid.WeatherApp.controllers.impl;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hybrid.WeatherApp.controllers.WeatherForecastController;
import hybrid.WeatherApp.dto.CityAverageTempDTO;
import hybrid.WeatherApp.services.WeatherForecastService;

@RestController
@RequestMapping(value = "/api/forecast")
public class WeatherForecastControllerImpl implements WeatherForecastController {

	private final WeatherForecastService wheaterForcastService;

	@Autowired
	public WeatherForecastControllerImpl(WeatherForecastService wheaterForcastService) {
		this.wheaterForcastService = wheaterForcastService;
	}

	@GetMapping(value = "/averageTemp")
	public ResponseEntity<?> getAverageTemperatures(@RequestParam(required = false) List<String> cities,
			@RequestParam(required = true) Instant fromDate, @RequestParam(required = true) Instant toDate,
			@RequestParam(defaultValue = "true") Boolean sortAsc) {
		List<CityAverageTempDTO> avgTemps = this.wheaterForcastService.getAverageTemperatures(cities, fromDate, toDate,
				sortAsc);
		HttpStatus status = avgTemps.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
		return new ResponseEntity<List<CityAverageTempDTO>>(avgTemps, status);
	}

}
