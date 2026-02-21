package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.Payment;
import dev.abhishek.bookmyshow.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;

    @Override
    public Payment getPaymentById(Integer paymentId) {
        return paymentRepo.findById(paymentId).get();
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    @Override
    public void savePayment(Payment payment) {
        paymentRepo.save(payment);
    }

    @Override
    public void deletePaymentById(Integer paymentId) {
        paymentRepo.deleteById(paymentId);
    }
}

