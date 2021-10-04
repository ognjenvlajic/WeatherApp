package hybrid.WeatherApp.dto;

import java.time.Instant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "ForecastListElementDTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ForecastListElementDTO {

	@ApiModelProperty(value = "Timestamp for which forecast is showed")
	private Instant dt;
	
	@ApiModelProperty(value = "Main forecast data")
	private ForecastMainDTO main;
	
}
