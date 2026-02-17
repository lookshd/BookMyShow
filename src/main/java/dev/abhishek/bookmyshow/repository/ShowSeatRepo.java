package dev.abhishek.bookmyshow.repository;

import dev.abhishek.bookmyshow.entity.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepo extends JpaRepository<ShowSeat,Integer> {
}
