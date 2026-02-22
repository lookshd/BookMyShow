package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.ShowSeat;
import dev.abhishek.bookmyshow.repository.ShowSeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowSeatServiceImpl implements  ShowSeatService {
    @Autowired
    private ShowSeatRepo showSeatRepo;

    @Override
    public List<ShowSeat> getShowSeatsByShowId(List<Integer> showId) {
        // Logic to fetch show seats based on showId
        return showSeatRepo.findAllById(showId);
    }

    @Override
    public ShowSeat updateShowSeat(ShowSeat showSeat)
    {
        return showSeatRepo.save(showSeat);
    }

    @Override
    public ShowSeat save(ShowSeat showSeat)
    {
        return showSeatRepo.save(showSeat);
    }

    @Override
    public void deleteShowSeatById(Integer showSeatId)
    {
        showSeatRepo.deleteById(showSeatId);
    }


}
