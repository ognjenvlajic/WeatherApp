package hybrid.WeatherApp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "ForecastMainDTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ForecastMainDTO {

	@ApiModelProperty(value = "Temperature")
	private Double temp;
	
}
