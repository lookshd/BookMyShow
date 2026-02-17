package dev.abhishek.bookmyshow.repository;

import dev.abhishek.bookmyshow.entity.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepo extends JpaRepository<Auditorium, Integer> {
}
