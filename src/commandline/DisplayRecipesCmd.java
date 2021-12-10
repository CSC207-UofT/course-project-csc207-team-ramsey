package commandline;

import constants.MealCountry;
import constants.MealTime;
import controllers.RecipeControlCentre;
import entities.Recipe;

import java.util.*;

public class DisplayRecipesCmd<T> extends Command<T> implements CommandExecute{

    public DisplayRecipesCmd(T receiver) {
        super(0, 0, receiver);
    }

    /**
     * execute DisplayRecipesCmd
     * @param arguments is the input arguments for DisplayRecipeCmd
     * @return a String message for DisplayRecipeCmd
     */
    @Override
    public String execute(List<String> arguments) {
        RecipeControlCentre recipeControlCentre = (RecipeControlCentre) receiver;

        List<Recipe> recipeList = recipeControlCentre.getListByCategory(arguments.get(0));

        if (recipeList == null || recipeList.isEmpty()){
            return "You have no recipes here.";
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

    /**
     * initiate the command line call for CreateRecipeCmd
     * @param s is a Scanner object
     */
    public void initiate(Scanner s){
        System.out.println("""
                Would you like to see all your recipes or recipes from one of the following categories: +
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
                System.out.println(execute(fullOrCat));
                successful = true;
            } else {
                if (checkedCategories(input)){
                    fullOrCat.add(input);
                    System.out.println(execute(fullOrCat));
                    successful = true;
                } else {
                    System.out.println("One or more of your categories appears to be inconsistent with our database. Please, try again.");
                }
            }
        }
    }

    /**
     * a helper method to check if user's inputed category matches a category from category enums
     * @param category  is  the input category from the user
     * @return boolean for whether category exists
     */
    private static boolean checkedCategories(String category){

        if (MealCountry.matchIgnoreCase(category)){
            return true;
        }
        return MealTime.matchIgnoreCase(category);
    }

}
