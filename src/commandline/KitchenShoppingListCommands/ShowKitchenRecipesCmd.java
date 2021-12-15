package commandline.KitchenShoppingListCommands;

import commandline.Command;
import commandline.CommandExecute;
import controllers.KitchenControlCentre;
import entities.Recipe;

import java.util.*;

public class ShowKitchenRecipesCmd<T> extends Command<T> implements CommandExecute {

    public ShowKitchenRecipesCmd(T receiver) {
        super(5, 5, receiver);
    }


    /**
     * execute ShowKitchenRecipes
     * @param arguments is the input arguments for the ShowKitchenRecipes Command
     * @return String response message from command
     */
    @Override
    public String execute(List<String> arguments) {
        if (arguments.get(0) == "YES") {
            ArrayList<Recipe> recipeList = ((KitchenControlCentre) receiver).getUser().getKitchen().getRecipes();
            KitchenControlCentre kitchenControlCentre = (KitchenControlCentre) receiver;

            if (recipeList == null || recipeList.isEmpty()) {
                return "You currently have no recipes in your kitchen.";
            } else {
                StringBuilder recipes = new StringBuilder();
                recipes.append("You currently have the following recipes in your kitchen: " + "\n");
                return kitchenControlCentre.getRecipeList(((KitchenControlCentre) receiver).getUser()).toString();
            }
        } else {
            return "Ok, return to the main menu";
        }
    }

    /**
     * initiate line call for ShowKitchenRecipes Command
     * @param s a Scanner object to get input from user
     */
    @Override
    public void initiate(Scanner s) {
        System.out.println("Would you like to see your full list? Input 'YES' or 'NO'.");
        String response = s.nextLine();
        List<String> args = new ArrayList<>();
        if (response.equals("YES") || response.equals("NO")){
            args.add(response);
            System.out.println(execute(args));
        } else {
            System.out.println("I'm sorry, that response is invalid. Please, try again.");
        }
    }
}
