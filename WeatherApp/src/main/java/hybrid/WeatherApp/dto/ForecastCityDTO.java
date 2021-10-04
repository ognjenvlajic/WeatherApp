package hybrid.WeatherApp.dto;

import hybrid.WeatherApp.models.City;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "ForecastCityDTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ForecastCityDTO {
	
	@ApiModelProperty(value = "City identifier")
	private Long id;
	
	@ApiModelProperty(value = "City name")
	private String name;
	
	@ApiModelProperty(value = "Country of city")
	private String country;
	
	public ForecastCityDTO(City city) {
		this.id = city.getId();
		this.name = city.getName();
		this.country = city.getCountry();
	}

}
