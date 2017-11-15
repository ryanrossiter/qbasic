package com.queensu.cisc.qbasic.backend.transaction;

import com.queensu.cisc.qbasic.backend.AccountManager;
//Handles the withdraw transaction, receives input from TransactionRegistry.java.
public class WithdrawTransaction implements Transaction {

    @Override
    public String getTransactionString() {
        return "WDR";
    }

    @Override
    public void processTransaction(int accountNum0, int amount, int accountNum1, String accountName) {
        AccountManager.Account acc = AccountManager.GetAccount(accountNum0);
        acc.setBalance(acc.getBalance() - amount);
    }
}
