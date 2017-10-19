package com.queensu.cisc.qbasic.frontend.command;
import com.queensu.cisc.qbasic.frontend.AccountManager;
import com.queensu.cisc.qbasic.frontend.TransactionSummarizer;
import com.queensu.cisc.qbasic.frontend.Input.java

import java.util.Scanner;

public class WithdrawCommand implements Command {

    public boolean invoke(String accountType) {
        Integer accNum = null;
        Integer amount = null;

        while (accNum == null){
            System.out.print("Enter a valid account number: ");
            try {
                accNum = scanner.nextInt();
            } catch (Exception e) {}

            if (AccountManager.Exists(accNum) == false) {
                System.out.println("Account number is invalid.");
                accNum = null;
            }
        }

        while (amount == null){
            System.out.print("Enter a valid amount to withdraw: ");
            try {
                accNum = scanner.nextInt();
            } catch (Exception e) {}

            if (amount != null && amount > 100000) {
                System.out.println("Value must be less than 100000.");
                amount = null;
            }
        }

        TransactionSummarizer.RecordTransaction("WDR", accNum, amount, null,null);

        return false;
    }
}