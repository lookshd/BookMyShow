  package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.*;
import java.util.List;

public interface IntializationService {
    void run(String... args) throws Exception;
    void demoDataIntialization();
    City createCity();
    List<Theatre> createTheatres(City city);
    void createAuditoriums(Theatre theatre);
    void createSeats(Auditorium auditorium);
    List<Movie> createMovies();
    void createShows(List<Theatre> theatres, List<Movie> movies);
    void createShowSeats(Show show, Auditorium auditorium);
    void createUsers();
}

