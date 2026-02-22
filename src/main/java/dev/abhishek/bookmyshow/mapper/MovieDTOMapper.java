package dev.abhishek.bookmyshow.mapper;

import dev.abhishek.bookmyshow.dto.MovieListDTO;
import dev.abhishek.bookmyshow.entity.Movie;

public class MovieDTOMapper {
    public static MovieListDTO MovieListDTORespToMovieListDTO(Movie movie){
        return new MovieListDTO(
                movie.getGenre(),
                movie.getId(),
                movie.getMovieName(),
                movie.getRating(),
                movie.getVotes()
        );
    }
}
