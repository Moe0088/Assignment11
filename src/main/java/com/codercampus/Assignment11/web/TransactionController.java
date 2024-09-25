package com.codercampus.Assignment11.web;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TranscationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

import static com.codercampus.Assignment11.service.TranscationService.*;

@Controller
public class TransactionController {

    @Autowired
    private TranscationService transcationService;

    @GetMapping("/transactions")
    public String getTransactions(ModelMap model) {
        List<Transaction> transactionList = transcationService.findAll();
        Transaction transaction = new Transaction();
        model.put("transactions", transactionList);
        return "transactions";

    }

    @GetMapping("/transactions/{transactionId}")
    public String getTransactionById(@PathVariable Long transactionId, ModelMap model) {

        Transaction transaction = transcationService.getTransactionById(transactionId);
        model.put("transaction", transaction);

        return "transactionDetails";

    }

}
