package com.queensu.cisc.qbasic.backend.transaction;
//Inherited by: DepositTransaction.java, CreateAccountTransaction.java, DeleteAccountTransaction.java,
//TransferTransaction.java, and WithdrawTransaction.java

//An interface for a transaction.
public interface Transaction {
    String getTransactionString();

    void processTransaction(int accountNum0, int amount, int accountNum1, String accountName);
}
