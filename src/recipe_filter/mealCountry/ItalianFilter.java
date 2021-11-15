package recipe_filter.mealCountry;

import constants.MealCountry;
import entities.Recipe;

import java.util.ArrayList;
import java.util.List;

public class ItalianFilter {
    public List<Recipe> apply(List<Recipe> recipes) {
        List<Recipe> filteredRecipes = new ArrayList<>();

        if (recipes != null){
            for (Recipe recipe : recipes){
                if (MealCountry.ITALIAN.toString().equalsIgnoreCase(recipe.getCategoryCountry())){
                    filteredRecipes.add(recipe);
                }
            }
        }
        return filteredRecipes;
    }
}
