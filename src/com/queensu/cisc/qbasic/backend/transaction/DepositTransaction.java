package com.queensu.cisc.qbasic.backend.transaction;

import com.queensu.cisc.qbasic.backend.AccountManager;
//Handles the deposit transaction, gets input from TransactionRegistry.java.
public class DepositTransaction implements Transaction {

    @Override
    public String getTransactionString() {
        return "DEP";
    }

    // Deposits amount into the account associated with accountNum0
    @Override
    public void processTransaction(int accountNum0, int amount, int accountNum1, String accountName) {
        AccountManager.Account acc = AccountManager.GetAccount(accountNum0);
        if (acc == null) {
            System.out.println("Account number " + accountNum0 + " does not exist.");
        } else {
            acc.setBalance(acc.getBalance() + amount);
        }
    }
}
