package recipe_filter.mealCountry;

import constants.MealCountry;
import constants.MealTime;
import entities.Recipe;

import java.util.ArrayList;
import java.util.List;

public class AmericanFilter {
    public List<Recipe> apply(List<Recipe> recipes) {
        List<Recipe> filteredRecipes = new ArrayList<>();

        if (recipes != null){
            for (Recipe recipe : recipes){
                if (MealCountry.AMERICAN.toString().equalsIgnoreCase(recipe.getCategoryCountry())){
                    filteredRecipes.add(recipe);
                }
            }
        }
        return filteredRecipes;
    }
}
