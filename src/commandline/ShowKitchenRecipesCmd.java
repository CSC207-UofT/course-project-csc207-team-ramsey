package commandline;

import controllers.ControlCentre;
import controllers.KitchenControlCentre;
import entities.Recipe;
import entities.User;

import java.util.*;

public class ShowKitchenRecipesCmd extends Command implements CommandExecute{

    public ShowKitchenRecipesCmd(ControlCentre receiver) {
        super(0, 0, receiver);
    }


    @Override
    public String execute(ControlCentre receiver, List<String> arguments, User user) {
        ArrayList<Recipe> recipeList = user.getKitchen().getRecipes();
        KitchenControlCentre kitchenControlCentre = (KitchenControlCentre) receiver;

        if (recipeList == null || recipeList.isEmpty()){
            return "You currently have no recipes in your kitchen.";
        } else {
            StringBuilder recipes = new StringBuilder();
            recipes.append("You currently have the following recipes in your kitchen: " + "\n");
            return kitchenControlCentre.getRecipeList(user).toString();
        }
    }
}
