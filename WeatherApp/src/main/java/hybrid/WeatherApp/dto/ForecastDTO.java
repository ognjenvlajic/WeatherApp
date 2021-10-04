package hybrid.WeatherApp.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "ForecastDTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ForecastDTO {

	@ApiModelProperty(value = "List of forecast data")
	private List<ForecastListElementDTO> list;
	
	@ApiModelProperty(value = "City for which forecast is retrived")
	private ForecastCityDTO city;
	
}
