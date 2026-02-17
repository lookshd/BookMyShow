package dev.abhishek.bookmyshow.entity;

import dev.abhishek.bookmyshow.entity.constants.PaymentStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Payment extends BaseModel{
    @OneToMany
    @JoinColumn(name = "payment_id")
    private List<Transaction> transactions;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    private int totalAmount;

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
