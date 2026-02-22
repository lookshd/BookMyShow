package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.Movie;

import java.util.List;

public interface MovieService {
    public Movie getMovieById(Integer movieId);
    public List<Movie> getAllMovies();
    public Movie saveMovie(Movie movie);
    public void deleteMovieById(Integer movieId);
    public List<Movie> getMoviesByCity(String city);
}

