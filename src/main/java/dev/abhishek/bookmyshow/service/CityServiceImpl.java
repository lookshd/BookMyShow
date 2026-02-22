package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.City;
import dev.abhishek.bookmyshow.repository.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public City saveCity(City city)
    {
        return cityRepo.save(city);
    }

    @Override
    public void deleteCityByID(int city_id) {
        cityRepo.deleteById(city_id);
    }

    @Override
    public City updateCityByID(int city_id, City new_city) {
        City city = cityRepo.findById(city_id).orElse(null);
        if(city!=null)
        {
            city.setCityName(new_city.getCityName());
            return cityRepo.save(city);
        }
        return null;
    }
}
