package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.Auditorium;
import dev.abhishek.bookmyshow.repository.AuditoriumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {
    @Autowired
    private AuditoriumRepo auditoriumRepo;

    @Override
    public Auditorium getAuditoriumById(Integer auditoriumId) {
        return auditoriumRepo.findById(auditoriumId).get();
    }

    @Override
    public List<Auditorium> getAllAuditoriums() {
        return auditoriumRepo.findAll();
    }

    @Override
    public void saveAuditorium(Auditorium auditorium) {
        auditoriumRepo.save(auditorium);
    }

    @Override
    public void deleteAuditoriumById(Integer auditoriumId) {
        auditoriumRepo.deleteById(auditoriumId);
    }
}

