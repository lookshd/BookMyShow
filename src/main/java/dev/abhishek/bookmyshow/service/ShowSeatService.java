package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.ShowSeat;

import java.util.List;

public interface ShowSeatService {
        public ShowSeat updateShowSeat(ShowSeat showSeat);
        public List<ShowSeat> getShowSeatsByShowId(List<Integer> showId);
        public ShowSeat save(ShowSeat showSeat);
        public void deleteShowSeatById(Integer showSeatId);


}
