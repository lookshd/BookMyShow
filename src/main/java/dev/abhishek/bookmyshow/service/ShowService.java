package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.Show;

import java.util.List;

public interface ShowService {
    public Show getShowById(Integer showId);
    public List<Show> getAllShows();
    public void  saveShow(Show show);
    public void deleteShowById(Integer showId);
}
