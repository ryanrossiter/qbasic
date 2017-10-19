public class Login {
    public static CommandRegistry verify(String input){
        if (input.equals("login agent"){
            return CommandRegistryFactory.CreateAgentCommandRegistry();
        }
        else if (input.equals("login agent"){
            return CommandRegistryFactory.CreateAgentCommandRegistry();
        }
        else{
            return null;
        }
    }
}