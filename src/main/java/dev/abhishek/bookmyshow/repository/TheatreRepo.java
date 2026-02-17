package dev.abhishek.bookmyshow.repository;

import dev.abhishek.bookmyshow.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre, Integer> {
}
