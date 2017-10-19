import java.util.Scanner;
public class Input{
    public String askForAccountNumber(same_line) {
        private static Scanner scanner = new Scanner(System.in);
        //same_line is the input if the user entered all the input on one line instead of hitting enter
        noNum = true;
        String accNum = same_line;
        Integer accNum = null;
        while (accNum == null) {
            System.out.print("Enter a valid account number: ");
            try {
                accNum = scanner.nextInt();
            } catch (Exception e) {
            }

            if (AccountManager.Exists(accNum) == false) {
                System.out.println("Account number is invalid.");
                accNum = null;
            }
            }
        }
        return accNum.toString();
    }
    public String askForAmount(same_line, login_type) {
        int max_amount;
        Integer amount = null;
        if (login_type == machine)
            max_amount = 100000;
        else
            max_amount = 99999999;
        while (amount == null){
            System.out.print("Enter a valid amount to withdraw: ");
            try {
                accNum = scanner.nextInt();
            } catch (Exception e) {}

            if ((amount != null) && (amount > max_amount)) {
                System.out.println("Value must be less than %d", max_amount);
                amount = null;
            }
        }
        return max_amount.toString();
    }
}