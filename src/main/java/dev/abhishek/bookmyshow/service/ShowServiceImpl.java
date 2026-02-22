package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.Show;
import dev.abhishek.bookmyshow.repository.ShowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    private ShowRepo showRepo;

    @Override
    public Show getShowById(Integer showId) {
        return showRepo.findById(showId).get();
    }

    @Override
    public List<Show> getAllShows() {
        return showRepo.findAll();
    }

    @Override
    public Show saveShow(Show show) {

        return showRepo.save(show);
    }

    @Override
    public void deleteShowById(Integer showId) {
        showRepo.deleteById(showId);
    }
}
