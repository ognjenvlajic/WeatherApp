package hybrid.WeatherApp.services;

import java.util.List;

import hybrid.WeatherApp.models.City;

public interface CityService {

    /**
     * Method saves forwarded City in base
     *
     * @param - city
     * @return - saved City entity
     */
	public City saveCity(City city);
	
    /**
     * Method finds all cities from base
     *
     * @return - List of all cities from base
     */
	public List<City> findAll();
	
    /**
     * Method finds all cities from base for forwarded names
     *
     * @param cityNames - List of city names
     * @return - List of cities
     */
	public List<City> findByNames(List<String> cityNames);
	
}
