package dev.abhishek.bookmyshow.entity;

import dev.abhishek.bookmyshow.entity.constants.TicketStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ticket extends  BaseModel{
    @OneToOne
    private  Payment payment;
    @OneToMany
    @JoinColumn(name = "ticket_id")
    private List<ShowSeat> showSeat;
    @ManyToOne
    private Show show;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;
    @ManyToOne
    private Theatre theatre;

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

    public String getTheatreName() {
        return theatre != null ? theatre.getTheatreName() : null;
    }

    public void setTheatreName(String theatreName) {
        if (this.theatre == null) {
            this.theatre = new Theatre();
        }
        this.theatre.setTheatreName(theatreName);
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}
