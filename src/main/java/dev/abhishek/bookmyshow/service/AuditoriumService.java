package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.Auditorium;

import java.util.List;

public interface AuditoriumService {
    public Auditorium getAuditoriumById(Integer auditoriumId);
    public List<Auditorium> getAllAuditoriums();
    public Auditorium saveAuditorium(Auditorium auditorium);
    public void deleteAuditoriumById(Integer auditoriumId);
}

