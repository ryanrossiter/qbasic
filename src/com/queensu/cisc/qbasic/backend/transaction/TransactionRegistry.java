package com.queensu.cisc.qbasic.backend.transaction;

import java.util.HashMap;
import java.util.Map;

/*
    The TransactionRegistry is responsible for initializing the transaction handlers,
    and invoking the appropriate transaction handler when the processTransaction method
    is called by the TransactionSummaryProcessor.
 */
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

    // Adds a transaction handler instance to the transactions map
    private void registerTransaction(Transaction t) {
        transactions.put(t.getTransactionString(), t);
    }

    // Accepts parsed transaction input and invokes the appropriate transaction handler's processTransaction
    // method if one is registered, otherwise it prints an error for the unknown transaction code.
    public void processTransaction(String transactionCode, int accountNum0, int amount, int accountNum1, String accountName) {
        if (transactions.containsKey(transactionCode)) {
            transactions.get(transactionCode).processTransaction(accountNum0, amount, accountNum1, accountName);
        } else {
            System.out.println("Unknown transaction code \"" + transactionCode + "\".");
        }
    }
}
