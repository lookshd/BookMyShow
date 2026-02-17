package dev.abhishek.bookmyshow.dto;

import java.time.LocalDateTime;
import java.util.List;

public class TicketRespDTO {
    private  int id;
    private String movieTitle;
    private LocalDateTime showStartTime;
    private List<String> seatNumbers;
    private String auditoriumName;
    private String theaterName;

    public  TicketRespDTO() {};

    public TicketRespDTO(int id, String movieTitle, LocalDateTime showStartTime, List<String> seatNumbers, String theaterName, String auditoriumName) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.showStartTime = showStartTime;
        this.seatNumbers = seatNumbers;
        this.theaterName = theaterName;
        this.auditoriumName = auditoriumName;
    }

    public String getAuditoriumName() {
        return auditoriumName;
    }

    public void setAuditoriumName(String auditoriumName) {
        this.auditoriumName = auditoriumName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public LocalDateTime getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(LocalDateTime showStartTime) {
        this.showStartTime = showStartTime;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }
}
