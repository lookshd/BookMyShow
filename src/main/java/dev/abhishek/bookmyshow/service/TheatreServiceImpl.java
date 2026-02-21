package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.Theatre;
import dev.abhishek.bookmyshow.repository.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {
    @Autowired
    private TheatreRepo theatreRepo;

    @Override
    public Theatre getTheatreById(Integer theatreId) {
        return theatreRepo.findById(theatreId).get();
    }

    @Override
    public List<Theatre> getAllTheatres() {
        return theatreRepo.findAll();
    }

    @Override
    public void saveTheatre(Theatre theatre) {
        theatreRepo.save(theatre);
    }

    @Override
    public void deleteTheatreById(Integer theatreId) {
        theatreRepo.deleteById(theatreId);
    }
}

