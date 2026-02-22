package dev.abhishek.bookmyshow.entity;

import dev.abhishek.bookmyshow.entity.constants.Feature;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Movie extends BaseModel {
    private String movieName;
    private String genre;
    private int durationInMinutes;
    private String Rating;
    private String votes;
    private String releaseDate;
    private String about;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
