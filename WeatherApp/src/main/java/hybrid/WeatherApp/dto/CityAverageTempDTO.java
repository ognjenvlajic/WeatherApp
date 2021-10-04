package hybrid.WeatherApp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "CityAvarageTempDTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CityAverageTempDTO {

	@ApiModelProperty(value = "City")
	ForecastCityDTO city;
	
	@ApiModelProperty(value = "Average temperature for city")
	Double avgTemp;
	
}
