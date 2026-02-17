package dev.abhishek.bookmyshow.repository;

import dev.abhishek.bookmyshow.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<City, Integer> {
}
