package hybrid.WeatherApp.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/api/cities")
public interface CityController {

	@ApiOperation(value = "Get cities for which forecast is available", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return list of cities"),
			@ApiResponse(code = 204, message = "Return empty list") })
	public ResponseEntity<?> getAvailableCities();

}
