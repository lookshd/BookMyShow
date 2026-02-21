package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.Seat;
import dev.abhishek.bookmyshow.repository.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatRepo seatRepo;

    @Override
    public Seat getSeatById(Integer seatId) {
        return seatRepo.findById(seatId).get();
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepo.findAll();
    }

    @Override
    public void saveSeat(Seat seat) {
        seatRepo.save(seat);
    }

    @Override
    public void deleteSeatById(Integer seatId) {
        seatRepo.deleteById(seatId);
    }
}

