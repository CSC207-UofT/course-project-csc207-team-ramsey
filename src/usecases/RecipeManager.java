package usecases;

import entities.Recipe;
import entities.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A RecipeManager that Manages the Recipes and the User Recipe List
 */
public class RecipeManager {

    /**
     *
     * @param user a user of the program
     * @param servings the number of people the recipe serves
     * @param name the name of the recipe
     * @param time the time it takes to cook in minutes
     * @param steps the instructions of the recipe
     * @param ingredients the required ingredients and their quantities
     * @return boolean showing whether recipe was added
     */
    public boolean addNewRecipe(User user, int servings, String name, int time, String steps, HashMap<String, Float> ingredients){

        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();

        for(Recipe recipe : curRecipes){
            if (recipe.getTitle().equals(name)){
                return false;
            }
        }
        Recipe newRecipe = new Recipe(servings, name, time, steps, ingredients);
        user.getKitchen().getRecipes().add(newRecipe);
        return true;
    }

    /**
     * remove a recipe from the user's kitchen
     * @param user a user of the program
     * @param name the name of the recipe
     * @return boolean showing whether recipes was removed
     */
    public boolean removeRecipe(User user, String name){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (int i =0; i < curRecipes.size(); i++){
            if (curRecipes.get(i).getTitle().equals(name)){
                curRecipes.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * change Recipe name to a newName
     * @param user a user of the program
     * @param currName the name of the recipe
     * @param newName the new name of the recipe
     * @return boolean representing whether new name was set
     */
    public boolean changeRecipeName(User user, String currName, String newName) {
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (Recipe curRecipe : curRecipes) {
            if (curRecipe.getTitle().equals(currName)) {
                curRecipe.setTitle(newName);
                return true;
            }
        }
        return false;
    }

    /**
     * change recipe servings
     * @param user a user of the program
     * @param recipeName the name of the recipe
     * @param newServings the new servings of the recipe
     * @return boolean value showing whether newServings was set
     */
    public boolean changeRecipeServings(User user, String recipeName, int newServings){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (Recipe curRecipe : curRecipes) {
            if (curRecipe.getTitle().equals(recipeName)) {
                curRecipe.setServings(newServings);
                return true;
            }
        }
        return false;
    }

    /**
     * change recipe prepTime
     * @param user  a user of the program
     * @param recipeName the name of the recipe
     * @param newPrepTime the new preptime of the recipe
     * @return boolean value depending on whether recipe preptime is changed
     */
    public boolean changeRecipePrepTime(User user, String recipeName, int newPrepTime){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (Recipe curRecipe : curRecipes) {
            if (curRecipe.getTitle().equals(recipeName)) {
                curRecipe.setPrepTime(newPrepTime);
                return true;
            }
        }
        return false;
    }

    /**
     * change recipe instructions
     * @param user a user of the program
     * @param recipeName the name of the recipe
     * @param newInstructions the new instructions of the recipe
     * @return boolean value depending on whether recipe instructions are changed
     */
    public boolean changeRecipeSteps(User user, String recipeName, String newInstructions){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (Recipe curRecipe : curRecipes) {
            if (curRecipe.getTitle().equals(recipeName)) {
                curRecipe.setInstructions(newInstructions);
                return true;
            }
        }
        return false;
    }

    /**
     * change the ingredients of the recipe
     * @param user a user of the program
     * @param recipeName the name of the recipe
     * @param newIngredients the new ingredients of the recipe
     * @return boolean value depending on whether recipe ingredients is changed
     */
    public boolean changeIngredients(User user, String recipeName, HashMap<String, Float> newIngredients){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (Recipe curRecipe : curRecipes) {
            if (curRecipe.getTitle().equals(recipeName)) {
                curRecipe.setIngredients(newIngredients);
                return true;
            }
        }
        return false;
    }

}
