package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.Payment;

import java.util.List;

public interface PaymentService {
    public Payment getPaymentById(Integer paymentId);
    public List<Payment> getAllPayments();
    public void savePayment(Payment payment);
    public void deletePaymentById(Integer paymentId);
}

