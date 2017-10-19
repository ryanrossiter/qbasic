package com.queensu.cisc.qbasic.frontend.command;
import com.queensu.cisc.qbasic.frontend.AccountManager;
import com.queensu.cisc.qbasic.frontend.TransactionSummarizer;

import java.util.Scanner;

public class WithdrawCommand implements Command {
    private static Scanner scanner = new Scanner( System.in );
    public String COMMAND_STRING = "withdraw";

<<<<<<< HEAD
    public void invoke(String[] params) {
        String accNum = null;
        String amount = null;
        boolean noNum = true;
        if (0 <=params.length) {
            accNum = params[0];
        }
        if (params.length >1){
            amount = params[1];
        }
        while (noNum){
            if (accNum == null){}
            else if (accNum.matches("[0-9]") && accNum.length() == 7){
                if (AccountsManager.Exists(params[0])){
                    noNum = false;
                }
                else{
                    System.out.print("Please enter a valid account number: ");
                    accNum = scanner.nextLine();
                }
            }
            else{
                System.out.print("Please enter an 8-digit account number: ");
                accNum = scanner.nextLine();
            }
=======
    public boolean invoke(String accountType) {
        Integer accNum = null;
        Integer amount = null;
>>>>>>> 5640f44df0fcb4f50af603f6c731697da607d623

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