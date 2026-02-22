package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.Seat;

import java.util.List;

public interface SeatService {
    public Seat getSeatById(Integer seatId);
    public List<Seat> getAllSeats();
    public Seat saveSeat(Seat seat);
    public void deleteSeatById(Integer seatId);
}

