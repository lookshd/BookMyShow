package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.Show;
import dev.abhishek.bookmyshow.repository.ShowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowServiceImpl {
    @Autowired
    private ShowRepo showRepo;
    public Show getShowById(Integer showId){
    return showRepo.findById(showId).get();}
}
