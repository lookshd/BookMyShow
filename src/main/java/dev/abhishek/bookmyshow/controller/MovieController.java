package dev.abhishek.bookmyshow.controller;

import dev.abhishek.bookmyshow.dto.MovieListDTO;
import dev.abhishek.bookmyshow.entity.Movie;
import dev.abhishek.bookmyshow.mapper.MovieDTOMapper;
import dev.abhishek.bookmyshow.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;

    @GetMapping({"/explore/home", "/explore/home/", "/explore/home/{city}", "/explore/home/{city}/"})
    public ResponseEntity<List<MovieListDTO>> getMovies(
            @PathVariable(required = false) String city,
            @RequestParam(required = false) String cityParam) {

        // Use path variable if provided, otherwise use query parameter, default to Delhi
        String selectedCity = city != null ? city : (cityParam != null ? cityParam : "Delhi");

        System.out.println("Fetching movies for city: " + selectedCity);
        List<Movie>movies = movieService.getMoviesByCity(selectedCity);
        for(Movie movie:movies){
            System.out.println(movie);
        }
        List<MovieListDTO>MovieListDTOResp = movies.stream()
                        .map(MovieDTOMapper::MovieListDTORespToMovieListDTO).toList();
        for(MovieListDTO movieListDTO: MovieListDTOResp)
        {
           System.out.println(movieListDTO);
        }
        return ResponseEntity.ok(MovieListDTOResp);
    }

    @GetMapping("/explore/movies")
    public ResponseEntity<List<Movie>> getAllMovies()
    {
       List<Movie>movies = movieService.getAllMovies();
         return ResponseEntity.ok(movies);
    }
}


