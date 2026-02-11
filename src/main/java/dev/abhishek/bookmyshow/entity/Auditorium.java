package dev.abhishek.bookmyshow.entity;

import dev.abhishek.bookmyshow.entity.constants.Feature;

import java.util.List;

public class Auditorium extends BaseModel{
    private  String auditoriumName;
    private  List<Seat> seats;
    private List<Feature> features;

    public String getAuditoriumName() {
        return auditoriumName;
    }

    public void setAuditoriumName(String auditoriumName) {
        this.auditoriumName = auditoriumName;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
