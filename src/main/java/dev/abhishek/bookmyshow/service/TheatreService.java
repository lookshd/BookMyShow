package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.Theatre;

import java.util.List;

public interface TheatreService {
    public Theatre getTheatreById(Integer theatreId);
    public List<Theatre> getAllTheatres();
    public void saveTheatre(Theatre theatre);
    public void deleteTheatreById(Integer theatreId);
}

