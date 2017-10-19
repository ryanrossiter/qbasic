import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner( System.in );
    private static void Main{
        loop = true;
        while (loop){
            boolean login = false;
            CommandRegistry login_status = null;
            while (!login){
                String input = scanner.nextLine();
                if (Login.verify(input) != null) {
                    login = true;
                    login_status = Login.verify(input);
                }

            }
            command = true;
            while (command){
                String input = scanner.NextLine();
                String[] command = input.split(" ");
                String[] parameters = Arrays.copyOfRange(command, 1, command.length);
                boolean end = login_status.invokeCommand(inputs[0],inputs[1:]);
                if (end){
                    command = false;
                }
            }
        }
     }
 }