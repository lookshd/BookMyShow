package dev.abhishek.bookmyshow.repository;

import dev.abhishek.bookmyshow.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {
    @Query("""
    SELECT DISTINCT s.movie
                             FROM Show s
                             JOIN s.auditorium a
                             JOIN a.theatre t
                             JOIN t.city c
                             WHERE c.cityName = :city
""")
    List<Movie> findMoviesByCity(@Param("city") String city);
}
