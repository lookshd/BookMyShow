package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction getTransactionById(Integer transactionId);
    public List<Transaction> getAllTransactions();
    public void saveTransaction(Transaction transaction);
    public void deleteTransactionById(Integer transactionId);
}

