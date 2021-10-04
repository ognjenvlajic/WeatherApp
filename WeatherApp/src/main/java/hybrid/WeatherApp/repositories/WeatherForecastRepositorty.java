package hybrid.WeatherApp.repositories;

import java.time.Instant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hybrid.WeatherApp.models.City;
import hybrid.WeatherApp.models.WeatherForecast;

@Repository
public interface WeatherForecastRepositorty extends JpaRepository<WeatherForecast, Long> {

	// @Query("SELECT avg(wf.temp) FROM weather_forcast wf WHERE wf.city = ?1 AND wf.date BETWEEN ?2 AND ?3")
    @Query("SELECT avg(wf.temp) FROM WeatherForecast wf WHERE wf.city = :city AND wf.date BETWEEN :fromDate AND :toDate")
	Double getAvgTempForCity(@Param("city") City city, @Param("fromDate") Instant fromDate, @Param("toDate") Instant toDate);
	
}
