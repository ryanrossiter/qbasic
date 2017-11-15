package com.queensu.cisc.qbasic.backend.transaction;

import java.util.HashMap;
import java.util.Map;

public class TransactionRegistry {
    private Map<String, Transaction> transactions = new HashMap<>();

    public TransactionRegistry() {
        // Register transaction handlers here
    }

    public void processTransaction(String transactionID, int accountNum0, int amount, int accountNum1, String accountName) {
        if (transactions.containsKey(transactionID)) {
            transactions.get(transactionID).processTransaction(accountNum0, amount, accountNum1, accountName);
        } else {
            // err or something
        }
    }
}
