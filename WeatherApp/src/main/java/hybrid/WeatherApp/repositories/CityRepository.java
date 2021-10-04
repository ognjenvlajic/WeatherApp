package hybrid.WeatherApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hybrid.WeatherApp.models.City;

public interface CityRepository extends JpaRepository<City, Long> {

	List<City> findByNameIn(List<String> cityNames);
	
}
