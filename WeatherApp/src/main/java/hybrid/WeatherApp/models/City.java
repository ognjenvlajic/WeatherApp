package hybrid.WeatherApp.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import hybrid.WeatherApp.dto.ForecastCityDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class City implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String name;
	private String country;
	
	public City(ForecastCityDTO cityDTO) {
		this.id = cityDTO.getId();
		this.name = cityDTO.getName();
		this.country = cityDTO.getCountry();
	}
	
}
