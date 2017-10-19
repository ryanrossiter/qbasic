package com.queensu.cisc.qbasic.frontend.command;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import com.queensu.cisc.qbasic.frontend.TransactionSummarizer;
import com.queensu.cisc.qbasic.frontend.AccountManager;

public class WithdrawCommand implements Command {
    private static Scanner scanner = new Scanner( System.in );
    public String COMMAND_STRING = "withdraw";

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
            }

        }
        TransactionSummarizer.recordTransaction("WDR", accNum, amount,null,null);
    }
}
