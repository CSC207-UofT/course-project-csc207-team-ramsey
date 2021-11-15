package commandline;

import controllers.ControlCentre;
import controllers.RecipeControlCentre;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShowRecipeCmd extends Command implements CommandExecute{
    public ShowRecipeCmd(int maxArguments, int minArguments, ControlCentre receiver) {
        super(maxArguments, minArguments, receiver);
    }

    /**
     * execute the ShowRecipeCmd
     * @param receiver
     * @param arguments
     * @return
     */
    @Override
    public String execute(ControlCentre receiver, List<String> arguments) {
        RecipeControlCentre recipeControlCentre = (RecipeControlCentre) receiver;
        if (recipeControlCentre.checkInKitchen(arguments.get(0))){
            return recipeControlCentre.getRecipe(arguments.get(0));
        } else {
            return "There doesn't seem to be a recipe with that name. Please, try again.";
        }

    }

    /**
     * initiate the ShowRecipeCmd line call
     * @param s
     */
    public void showRecipeLineCall(Scanner s){
        RecipeControlCentre recipeControlCentre = (RecipeControlCentre) this.receiver;
        boolean success = false;

        if (recipeControlCentre.checkRecipesNotEmpty()){
            System.out.println("Which recipe would you like to see?");
            while (!success){
                String input = s.nextLine();
                List<String> arguments = new ArrayList<>();
                arguments.add(input);
                String output = execute(this.receiver, arguments);
                if (output.equals("There doesn't seem to be a recipe with that name. Please, try again.")){
                    System.out.println("There doesn't seem to be a recipe with that name. Please, try again.");
                } else {
                    System.out.println(output);
                    success = true;
                }
            }
        }

    }

}
