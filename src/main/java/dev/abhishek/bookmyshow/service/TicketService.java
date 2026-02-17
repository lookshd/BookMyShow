package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.Ticket;

import java.util.List;

public interface TicketService {

    public Ticket createTicket(List<Integer> showSeatIds, Integer userId);
}
