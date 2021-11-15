package commandline;

import constants.MealCountry;
import constants.MealTime;
import controllers.ControlCentre;
import controllers.RecipeControlCentre;
import entities.Recipe;
import entities.User;

import java.lang.reflect.Array;
import java.util.*;

public class DisplayRecipesCmd extends Command implements CommandExecute{

    public DisplayRecipesCmd(ControlCentre receiver) {
        super(0, 0, receiver);
    }


    @Override
    public String execute(ControlCentre receiver, List<String> arguments, User user) {
        RecipeControlCentre recipeControlCentre = (RecipeControlCentre) receiver;

        List<Recipe> recipeList = recipeControlCentre.getRecipeList(arguments.get(0));

        if (recipeList == null || recipeList.isEmpty()){
            return "You have no recipes in this category.";
        } else {
            StringBuilder message = new StringBuilder();
            message.append("You have the following recipes in this category: ");
            for(Recipe recipe : recipeList){
                message.append("\n -");
                message.append(recipe.getTitle());
            }
            return message.toString();
        }
    }

    public void displayRecipeLineCall(Scanner s){
        System.out.println("""
                Would you like to see all your recipes or recipes from one of the following categories:" +
                - American
                - Italian
                - French
                - Mexican
                - Chinese
                - Japanese
                - Korean
                
                - Breakfast
                - Brunch
                - Lunch
                - Dinner
                - Dessert
                
                If you want to see the full list, input full.
                If you want to see recipes from a certain category, please, type the category name instead.""");

        boolean successful = false;
        while (!successful){
            String input = s.nextLine();
            List<String> fullOrCat= new ArrayList<>();

            if (input.equals("full")){
                fullOrCat.add("full");
                System.out.println(execute(this.receiver, fullOrCat));
                successful = true;
            } else {
                if (checkedCategories(input)){
                    fullOrCat.add(input);
                    System.out.println(execute(this.receiver, fullOrCat));
                    successful = true;
                } else {
                    System.out.println("One or more of your categories appears to be inconsistent with out database. Please, try again.");
                }

            }
        }

    }

    private static boolean checkedCategories(String category){

        if (MealCountry.matchIgnoreCase(category)){
            return true;
        }
        return MealTime.matchIgnoreCase(category);
    }

}
