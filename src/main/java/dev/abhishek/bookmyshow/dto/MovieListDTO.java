package dev.abhishek.bookmyshow.dto;

public class MovieListDTO {
    private Integer movieID;
    private String movieName;
    private String movieGenre;
    private String Rating;
    private String votes;

    public MovieListDTO(){};

    public MovieListDTO(String movieGenre, Integer movieID, String movieName, String rating, String votes) {
        this.movieGenre = movieGenre;
        this.movieID = movieID;
        this.movieName = movieName;
        this.Rating = rating;
        this.votes = votes;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public Integer getMovieID() {
        return movieID;
    }

    public void setMovieID(Integer movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }
}
