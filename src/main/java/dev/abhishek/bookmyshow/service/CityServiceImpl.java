package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.City;
import dev.abhishek.bookmyshow.repository.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CityServiceImpl implements CityService{

    @Autowired
    private CityRepo cityRepo;

    @Override
    public List<City> getAllCities()
    {
        return cityRepo.findAll();
    }

    @Override
    public City getCityByID(Integer city_id)
    {
        return cityRepo.findById(city_id).orElse(null);
    }

    @Override
    public void saveCity(City city)
    {
        cityRepo.save(city);
    }

    @Override
    public void deleteCityByID(int city_id) {
        cityRepo.deleteById(city_id);
    }
}
