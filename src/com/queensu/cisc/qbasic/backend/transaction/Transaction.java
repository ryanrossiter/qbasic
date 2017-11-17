package com.queensu.cisc.qbasic.backend.transaction;
//Implemented by: DepositTransaction.java, CreateAccountTransaction.java, DeleteAccountTransaction.java,
//TransferTransaction.java, and WithdrawTransaction.java

//An interface for a transaction.
public interface Transaction {
    // Returns the 3 character transaction code that is used to identify the transaction
    String getTransactionString();

    // Invoked by the TransactionRegistry with the transaction parameters
    void processTransaction(int accountNum0, int amount, int accountNum1, String accountName);
}
