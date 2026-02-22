package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.Payment;
import dev.abhishek.bookmyshow.entity.ShowSeat;
import dev.abhishek.bookmyshow.entity.Ticket;
import dev.abhishek.bookmyshow.entity.User;
import dev.abhishek.bookmyshow.entity.constants.ShowSeatStatus;
import dev.abhishek.bookmyshow.entity.constants.TicketStatus;
import dev.abhishek.bookmyshow.exception.InvalidShowSeatException;
import dev.abhishek.bookmyshow.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private ShowServiceImpl showServiceImpl;
    @Autowired
    private ShowSeatServiceImpl showSeatServiceImpl;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE,rollbackFor = Exception.class)
    public Ticket createTicket(List<Integer> showIds, Integer userId) {
        User user = userServiceImpl.getUserById(userId);
        List<ShowSeat>showSeats = showSeatServiceImpl.getShowSeatsByShowId(showIds);
        for(ShowSeat showSeat : showSeats)
        {
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
            {
                throw  new InvalidShowSeatException("Show seat with id "+showSeat.getId()+" is not available");
            }
        }
        for(ShowSeat showSeat : showSeats)
        {
            showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
            showSeatServiceImpl.updateShowSeat(showSeat);
        }
        Payment payment = new Payment();
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setShowSeat(showSeats);
        ticket.setPayment(payment);
        ticket.setShow(showServiceImpl.getShowById(showSeats.getFirst().getShow().getId()));
        ticket.setTicketStatus(TicketStatus.BOOKED);
        Ticket savedTicket = ticketRepo.save(ticket);
        //BOOK THE SEATS
        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
            showSeatServiceImpl.updateShowSeat(showSeat);
        }
        return savedTicket;


    }
}
