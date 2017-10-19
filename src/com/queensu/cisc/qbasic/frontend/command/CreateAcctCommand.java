package com.queensu.cisc.qbasic.frontend.command;

public class CreateAcctCommand implements Command {
    public String COMMAND_STRING = "createacct";

<<<<<<< HEAD
    public boolean invoke(String[] params) {
        //shouldn't be accessible from machine mode
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

        }

=======
    public boolean invoke(String accountType) {
>>>>>>> 5640f44df0fcb4f50af603f6c731697da607d623
        return false;
    }
}
