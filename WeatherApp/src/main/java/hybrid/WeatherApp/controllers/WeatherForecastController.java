package hybrid.WeatherApp.controllers;

import java.time.Instant;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/api/forecast")
public interface WeatherForecastController {

	@ApiOperation(value = "Get sorted list of avarage temperatures per city", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "cities", dataType = "List", value = "List of city names", paramType = "query", required = false),
			@ApiImplicitParam(name = "fromDate", dataType = "Instant", value = "The beginning of date interval", paramType = "query", required = true),
			@ApiImplicitParam(name = "toDate", dataType = "Instant", value = "The end of date interval", paramType = "query", required = true),
			@ApiImplicitParam(name = "sortAsc", dataType = "Boolean", value = "Flag for sorting ascending", paramType = "query", required = false, defaultValue = "true") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return list of avarage temperatures per city"),
			@ApiResponse(code = 204, message = "Return empty list"),
			@ApiResponse(code = 400, message = "Bad request") })
	public ResponseEntity<?> getAverageTemperatures(List<String> cities, Instant fromDate, Instant toDate,
			Boolean sortAsc);

}
