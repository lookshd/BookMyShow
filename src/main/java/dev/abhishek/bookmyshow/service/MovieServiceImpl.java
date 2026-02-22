package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.Movie;
import dev.abhishek.bookmyshow.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepo movieRepo;

    @Override
    public Movie getMovieById(Integer movieId) {
        return movieRepo.findById(movieId).get();
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public List<Movie> getMoviesByCity(String city) {
        System.out.println("city" + city);
        return movieRepo.findMoviesByCity(city);
    }
    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepo.save(movie);
    }

    @Override
    public void deleteMovieById(Integer movieId) {
        movieRepo.deleteById(movieId);
    }
}

