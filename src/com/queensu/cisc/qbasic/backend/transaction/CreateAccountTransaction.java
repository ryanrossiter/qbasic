package com.queensu.cisc.qbasic.backend.transaction;

import com.queensu.cisc.qbasic.backend.AccountManager;

public class CreateAccountTransaction implements Transaction {

    @Override
    public String getTransactionString() {
        return "NEW";
    }

    @Override
    public void processTransaction(int accountNum0, int amount, int accountNum1, String accountName) {
        AccountManager.Create(accountNum0, accountName);
    }
}
