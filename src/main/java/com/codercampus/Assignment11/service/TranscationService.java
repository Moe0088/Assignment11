package com.codercampus.Assignment11.service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TranscationService {
    @Autowired
    private TransactionRepository transactionRepo;


    public List<Transaction> findAll() {
        List<Transaction> transactionList = transactionRepo.findAll();
        return transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getDate))
                .collect(Collectors.toList());
    }

    public Transaction getTransactionById(Integer transactionId) {
        return transactionRepo.findById(transactionId);
    }

}
