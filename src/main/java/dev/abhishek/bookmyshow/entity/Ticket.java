package dev.abhishek.bookmyshow.entity;

import dev.abhishek.bookmyshow.entity.constants.TicketStatus;

import java.util.List;

public class Ticket extends  BaseModel{
    private  Payment payment;
    private List<ShowSeat> showSeat;
    private Show show;
    private User user;
    private TicketStatus ticketStatus;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<ShowSeat> getShowSeat() {
        return showSeat;
    }

    public void setShowSeat(List<ShowSeat> showSeat) {
        this.showSeat = showSeat;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
