
public class Input{
    public String askForAccountNumber(same_line){
        //same_line is the input if the user entered all the input on one line instead of hitting enter
        noNum = true;
        String accNum = same_line;
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
        return accNum;
    }
    public String askForAmount(same_line, login_type) {
        int max_amount;
        if (login_type == machine)
            max_amount = 100000;
        else
            max_amount = 99999999;
        boolean noAmm = true;
        String amount = same_line;
        while (noAmm){
            if (amount == null){}
            else if (amount.matches("[0-9]")){
                if (Integer.parseInt(amount)<= max_amount){
                    noNum = false;
                }
                else{
                    System.out.print("Amount too large, please enter an amount under %d:", max_amount);
                    accNum = scanner.nextLine();
                }
            }
            else{
                System.out.print("Please enter an amount in cents: ");
                accNum = scanner.nextLine();
            }

        }
        TransactionSummarizer.recordTransaction("DEP", accNum, amount,null,null);
        return false;
    }
    }
}