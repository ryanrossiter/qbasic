package com.queensu.cisc.qbasic.frontend.command;
import com.queensu.cisc.qbasic.frontend.AccountManager;
import com.queensu.cisc.qbasic.frontend.TransactionSummarizer;

import java.util.Scanner;
<<<<<<< HEAD
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import com.queensu.cisc.qbasic.frontend.TransactionSummarizer;
import com.queensu.cisc.qbasic.frontend.AccountManager;
=======
>>>>>>> 5f3f3d4798a3558b85fa2ab1ea03d2cabc95605c

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
            else if (accNum.matches("[0-9]") && accNum.length() == 8){
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

        }
        boolean noAmm = true;
        while (noAmm){
            if (amount == null){}
            else if (amount.matches("[0-9]")){
                if (Integer.parseInt(amount)<= 100000){
                    noNum = false;
                }
                else{
                    System.out.print("Amount too large, cannont withdraw over 100000: ");
                    accNum = scanner.nextLine();
                }
            }
            else{
                System.out.print("Please enter an amount in cents: ");
                accNum = scanner.nextLine();
=======

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
>>>>>>> 5f3f3d4798a3558b85fa2ab1ea03d2cabc95605c
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
