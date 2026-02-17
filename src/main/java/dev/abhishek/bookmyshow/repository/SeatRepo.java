package dev.abhishek.bookmyshow.repository;

import dev.abhishek.bookmyshow.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepo extends JpaRepository<Seat, Integer> {
}
