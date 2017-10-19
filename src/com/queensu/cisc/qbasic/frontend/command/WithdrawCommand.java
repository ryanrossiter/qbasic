package com.queensu.cisc.qbasic.frontend.command;
import java.util.Scanner;
public class WithdrawCommand implements Command {
    private static Scanner scanner = new Scanner( System.in );
    public String COMMAND_STRING = "withdraw"

    public void invoke(String[] params) {
        String accNum;
        String amount;
        boolean noNum = true;
        if (params.length() >0) {
            accNum = params[0];
        }
        if params.length() >1){
            amount = params[1];
        }
        while (noNum){
            if (accNum == null){}
            else if (accNum.matches("[0-9]") && accNum.length == 8){
                if AccountsManager.Exists(params[0]){
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
            else if (amount.matches("[0-9]"){
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
        TransactionSummarizer.recordTransaction(COMMAND_STRING, accNum, amount);
    }
}
