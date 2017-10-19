package com.queensu.cisc.qbasic.frontend.command;
import java.util.Scanner;
public class WithdrawCommand implements Command {
    private static Scanner scanner = new Scanner( System.in );
    public String COMMAND_STRING = "withdraw"

    public void invoke(String[] params) {
        String accNum;
        String amount;
        boolean noNum = true;
        accNum = params[0];
        amount = params[1];
        while (noNum){
            if (amount == null){}
            else if (accNum.matches("[0-9]") && accNum.length == 8){
                if AccountsManager.Exists(params[0]){
                    noNum = false;
                }
            }
            else{
                System.out.print("Please enter a valid account number: ");
                accNum = scanner.nextLine();
            }

        }
    }
}
