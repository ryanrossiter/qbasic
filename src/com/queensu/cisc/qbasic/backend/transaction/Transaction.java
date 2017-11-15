package com.queensu.cisc.qbasic.backend.transaction;

public interface Transaction {
    String getTransactionString();

    void processTransaction(int accountNum0, int amount, int accountNum1, String accountName);
}
