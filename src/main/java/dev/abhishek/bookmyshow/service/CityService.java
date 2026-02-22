package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.City;

import java.util.List;

public interface CityService {
    public List<City> getAllCities();
    public City getCityByID(Integer city_id);
    public City saveCity(City city);
    public  void deleteCityByID(int city_id);
    public City updateCityByID(int city_id, City new_city);
}
