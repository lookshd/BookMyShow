package dev.abhishek.bookmyshow.repository;

import dev.abhishek.bookmyshow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
