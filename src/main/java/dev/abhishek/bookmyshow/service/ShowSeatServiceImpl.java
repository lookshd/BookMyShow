package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.ShowSeat;
import dev.abhishek.bookmyshow.repository.ShowSeatRepo;

import java.util.List;

public class ShowSeatServiceImpl {
    private ShowSeatRepo showSeatRepo;

    public List<ShowSeat> getShowSeatsByShowId(List<Integer> showId) {
        // Logic to fetch show seats based on showId
        return showSeatRepo.findAllById(showId);
    }

    public void updateShowSeat(ShowSeat showSeat)
    {
        showSeatRepo.save(showSeat);
    }

}
