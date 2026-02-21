package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.Transaction;
import dev.abhishek.bookmyshow.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public Transaction getTransactionById(Integer transactionId) {
        return transactionRepo.findById(transactionId).get();
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        transactionRepo.save(transaction);
    }

    @Override
    public void deleteTransactionById(Integer transactionId) {
        transactionRepo.deleteById(transactionId);
    }
}

