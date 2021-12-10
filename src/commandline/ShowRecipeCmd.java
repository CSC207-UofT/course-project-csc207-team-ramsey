package commandline;

import controllers.RecipeControlCentre;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShowRecipeCmd<T> extends Command<T> implements CommandExecute{
    public ShowRecipeCmd(T receiver) {
        super(0, 0, receiver);
    }

    /**
     * execute the ShowRecipeCmd
     * @param arguments is the arguments for ShowRecipeCmd
     * @return String message from command
     */
    @Override
    public String execute(List<String> arguments) {
        RecipeControlCentre recipeControlCentre = (RecipeControlCentre) receiver;
        if (recipeControlCentre.checkInKitchen(arguments.get(0))){
            return recipeControlCentre.getRecipeString(arguments.get(0));
        } else {
            return "There doesn't seem to be a recipe with that name. Please, try again.";
        }

    }

    /**
     * initiate the ShowRecipeCmd line call
     * @param s is a Scanner object
     */
    public void initiate(Scanner s){
        RecipeControlCentre recipeControlCentre = (RecipeControlCentre) this.receiver;
        boolean success = false;

        if (recipeControlCentre.checkRecipesNotEmpty()){
            System.out.println("Which recipe would you like to see?");
            while (!success){
                String input = s.nextLine();
                List<String> arguments = new ArrayList<>();
                arguments.add(input);
                String output = execute(arguments);
                if (output.equals("There doesn't seem to be a recipe with that name. Please, try again.")){
                    System.out.println("There doesn't seem to be a recipe with that name. Please, try again.");
                } else {
                    System.out.println(output);
                    success = true;
                }
            }
        } else {
            System.out.println("no recipes to show.");
        }

    }

}

