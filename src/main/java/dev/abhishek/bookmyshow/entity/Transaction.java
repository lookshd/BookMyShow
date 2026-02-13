package dev.abhishek.bookmyshow.entity;

import dev.abhishek.bookmyshow.entity.constants.PaymentStatus;
import dev.abhishek.bookmyshow.entity.constants.PaymentType;
import dev.abhishek.bookmyshow.entity.constants.TransactionPaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Transaction extends BaseModel{
    private String refrenceId;
    @Enumerated(EnumType.ORDINAL)
    private TransactionPaymentStatus transactionPaymentStatus;
    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;
    private int TransactionAmount;

    public TransactionPaymentStatus getPaymentStatus() {
        return transactionPaymentStatus;
    }

    public void setPaymentStatus(TransactionPaymentStatus transactionPaymentStatus) {
        this.transactionPaymentStatus = transactionPaymentStatus;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getRefrenceId() {
        return refrenceId;
    }

    public void setRefrenceId(String refrenceId) {
        this.refrenceId = refrenceId;
    }

    public int getTransactionAmount() {
        return TransactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        TransactionAmount = transactionAmount;
    }
}
