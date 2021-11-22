package commandline;

import entities.User;

import java.util.List;
import java.util.Scanner;

public class DeleteRecipe extends Command implements CommandExecute{

    public DeleteRecipe(int maxArguments, int minArguments, ControlCentre receiver) {
        super(1, 1, receiver);
    }

    @Override
    public String execute(ControlCentre receiver, List<String> arguments, User user) {
        return null;
    }

    public void deleteRecipeLineCall(Scanner s){
        System.out.println("Please, type which recipe you would like to delete or type exit to quit this command.");
        boolean success = false;

        while (!success){
            String input = s.nextLine();
            execute(this.receiver, input);

        }
    }
}
