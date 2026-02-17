package dev.abhishek.bookmyshow.mapper;

import dev.abhishek.bookmyshow.dto.TicketRespDTO;
import dev.abhishek.bookmyshow.entity.Seat;
import dev.abhishek.bookmyshow.entity.ShowSeat;
import dev.abhishek.bookmyshow.entity.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketDTOMapper {
    public static TicketRespDTO getTicketRespDTO(Ticket ticket){
        TicketRespDTO ticketRespDTO = new TicketRespDTO();
        ticketRespDTO.setId(ticket.getId());
        ticketRespDTO.setMovieTitle(ticket.getShow().getMovie().getMovieName());
        ticketRespDTO.setShowStartTime(ticket.getShow().getStartTime());
        ticketRespDTO.setAuditoriumName(ticket.getShow().getAuditorium().getAuditoriumName());
        ticketRespDTO.setTheaterName(ticket.getTheatreName());
        List<String> seats = new ArrayList<>();
        for(ShowSeat showSeat : ticket.getShowSeat()){
          seats.add(showSeat.getSeat().getSeatNumber());
        }
        ticketRespDTO.setSeatNumbers(seats);
        return ticketRespDTO;
    }
}
