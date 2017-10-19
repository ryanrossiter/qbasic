package com.queensu.cisc.qbasic.frontend.command;

public class TransferCommand implements Command {
    public String COMMAND_STRING = "transfer";

    public boolean invoke(String[] params) {
        String accNum = null;
        String amount = null;
        string accNum2 = null;
        boolean noNum = true;
        if (0 <=params.length) {
            accNum = params[0];
        }
        if (params.length >1){
            amount = params[1];
        }
        if (params.length >2){
            accNum2 = null;
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
        noNum = true;
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

        }
        TransactionSummarizer.recordTransaction("XFR", accNum, amount,null,null);
        return false;
    }
}
