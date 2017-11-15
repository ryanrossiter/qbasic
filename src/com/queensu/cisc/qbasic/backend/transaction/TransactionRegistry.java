package com.queensu.cisc.qbasic.backend.transaction;

import java.util.HashMap;
import java.util.Map;

public class TransactionRegistry {
    private Map<String, Transaction> transactions = new HashMap<>();

    public TransactionRegistry() {
        // Register transaction handlers here
        registerTransaction(new CreateAccountTransaction());
        registerTransaction(new DeleteAccountTransaction());
        registerTransaction(new DepositTransaction());
        registerTransaction(new WithdrawTransaction());
        registerTransaction(new TransferTransaction());
    }

    private void registerTransaction(Transaction t) {
        transactions.put(t.getTransactionString(), t);
    }

    public void processTransaction(String transactionID, int accountNum0, int amount, int accountNum1, String accountName) {
        if (transactions.containsKey(transactionID)) {
            transactions.get(transactionID).processTransaction(accountNum0, amount, accountNum1, accountName);
        } else {
            System.out.println("Unknown transaction code \"" + transactionID + "\".");
        }
    }
}
