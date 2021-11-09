package use_cases;

import Entities.Kitchen;
import Entities.Recipe;
import Entities.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A RecipeManager that Manages the Recipes and the User Recipe List
 */
public class RecipeManager {

    /**
     *
     * @param user
     * @param servings
     * @param name
     * @param time
     * @param steps
     * @param ingredients
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
     * @param user
     * @param name
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
     * @param user
     * @param currName
     * @param newName
     * @return boolean representing whether new name was set
     */
    public boolean changeRecipeName(User user, String currName, String newName) {
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (int i = 0; i < curRecipes.size(); i++){
            Recipe curRecipe = curRecipes.get(i);
            if (curRecipe.getTitle().equals(currName)){
                curRecipe.setTitle(newName);
                return true;
            }
        }
        return false;
    }

    /**
     * change recipe servings
     * @param user
     * @param recipeName
     * @param newServings
     * @return boolean value showing whether newServings was set
     */
    public boolean changeRecipeServings(User user, String recipeName, int newServings){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (int i = 0; i < curRecipes.size(); i++){
            Recipe curRecipe = curRecipes.get(i);
            if (curRecipe.getTitle().equals(recipeName)){
                curRecipe.setServings(newServings);
                return true;
            }
        }
        return false;
    }

    /**
     * change recipe prepTime
     * @param user
     * @param recipeName
     * @param newPrepTime
     * @return
     */
    public boolean changeRecipePrepTime(User user, String recipeName, int newPrepTime){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (int i = 0; i < curRecipes.size(); i++){
            Recipe curRecipe = curRecipes.get(i);
            if (curRecipe.getTitle().equals(recipeName)){
                curRecipe.setPrepTime(newPrepTime);
                return true;
            }
        }
        return false;
    }

    /**
     * change recipe instructions
     * @param user
     * @param recipeName
     * @param newInstructions
     * @return
     */
    public boolean changeRecipeSteps(User user, String recipeName, String newInstructions){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (int i = 0; i < curRecipes.size(); i++){
            Recipe curRecipe = curRecipes.get(i);
            if (curRecipe.getTitle().equals(recipeName)){
                curRecipe.setInstructions(newInstructions);
                return true;
            }
        }
        return false;
    }

    /**
     * change the ingredients of the recipe
     * @param user
     * @param recipeName
     * @param newIngredients
     * @return
     */
    public boolean changeIngredients(User user, String recipeName, HashMap<String, Float> newIngredients){
        ArrayList<Recipe> curRecipes = user.getKitchen().getRecipes();
        for (int i = 0; i < curRecipes.size(); i++){
            Recipe curRecipe = curRecipes.get(i);
            if (curRecipe.getTitle().equals(recipeName)){
                curRecipe.setIngredients(newIngredients);
                return true;
            }
        }
        return false;
    }

}
