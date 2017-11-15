package com.queensu.cisc.qbasic.backend.transaction;

import com.queensu.cisc.qbasic.backend.AccountManager;
//This handles the create account transaction, it is called by TransactionRegistry.java.
public class CreateAccountTransaction implements Transaction {
    @Override
    public String getTransactionString() {
        return "NEW";
    }

    @Override
    //Creates an Account with the specified number, name, and an amount of 0 cents.
    public void processTransaction(int accountNum0, int amount, int accountNum1, String accountName) {
        AccountManager.Create(accountNum0, accountName);
    }
}
