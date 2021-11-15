package recipe_filter.mealTime;

import constants.MealTime;
import entities.Recipe;

import java.util.ArrayList;
import java.util.List;

public class DessertFilter {

    public List<Recipe> apply(List<Recipe> recipes) {
        List<Recipe> filteredRecipes = new ArrayList<>();

        if (recipes != null){
            for (Recipe recipe : recipes){
                if (MealTime.DESSERT.toString().equalsIgnoreCase(recipe.getCategoryTime())){
                    filteredRecipes.add(recipe);
                }
            }
        }
        return filteredRecipes;
    }
}
