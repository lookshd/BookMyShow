package dev.abhishek.bookmyshow.entity;

import dev.abhishek.bookmyshow.entity.constants.PaymentStatus;

import java.util.List;

public class Payment extends BaseModel{
    private List<Transaction> transactions;
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
