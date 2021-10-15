package use_cases;

import Entities.Recipe;
import Entities.User;

import java.util.ArrayList;
import java.util.HashMap;

public class RecipeManager {

    public boolean addNewRecipe(User user, int servings, String name, int time, String steps, HashMap<String, Float> ingredients){
        for (Recipe recipe : user.getRecipes()){
            if (recipe.getTitle().equals(name)){
                return false;
            }
        }
        Recipe newRecipe = new Recipe(servings, name, time, steps, ingredients);
        user.addRecipe(newRecipe);
        return true;
    }

    public boolean removeRecipe(User user, String name){
        ArrayList<Recipe> recipeList = user.getRecipes();
        for (int i =0; i < recipeList.size(); i++){
            if (recipeList.get(i).getTitle().equals(name)){
                user.removeRecipe(i);
                return true;
            }
        }
        return false;
    }


    public boolean changeRecipeName(User user, String currName, String newName) {
        ArrayList<Recipe> recipeList = user.getRecipes();
        for (int i =0; i < recipeList.size(); i++){
            if (recipeList.get(i).getTitle().equals(currName)){
                user.removeRecipe(i);
                return true;
            }
        }
        return false;
    }

}
