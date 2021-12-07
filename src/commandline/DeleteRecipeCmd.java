package commandline;

import controllers.ControlCentre;
import controllers.RecipeControlCentre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DeleteRecipeCmd extends Command implements CommandExecute{

    public DeleteRecipeCmd(ControlCentre receiver) {
        super(1, 1, receiver);
    }

    /**
     * execute DeleteRecipe
     * @param arguments is the input arguments for DeleteRecipeCmd
     * @return String message from command
     */
    @Override
    public String execute(List<String> arguments) {
        RecipeControlCentre recipeControlCentre = (RecipeControlCentre) this.receiver;
        if (recipeControlCentre.removeRecipe(arguments.get(0))){
            return arguments.get(0) + " has been successfully removed from your recipe list.";
        } else {
            return "This recipe could not be found in your recipe list.";
        }

    }

    /**
     * initiate line call for DeleteRecipeCmd
     * @param s is a Scanner object
     */
    public void initiate(Scanner s){
        System.out.println("Please, type which recipe you would like to delete or type exit to quit this command.");

        do {
            String input = s.nextLine();
            ArrayList<String> inputList= new ArrayList<>();
            inputList.add(input);

            String result = execute(inputList);
            System.out.println(result);

            if (result.equals("This recipe could not be found in your recipe list.")){
                System.out.println("Would you like to try again(y/n)");
            } else {
                System.out.println("Would you like to delete another recipe(y/n)");
            }


        } while (!Objects.equals(s.nextLine(), "n"));
    }
}
