package recipe_filter.mealTime;

import constants.MealTime;
import entities.Recipe;
import recipe_filter.Filter;

import java.util.ArrayList;
import java.util.List;

public class BrunchFilter implements Filter {

    @Override
    public List<Recipe> apply(List<Recipe> recipes) {
        List<Recipe> filteredRecipes = new ArrayList<>();

        if (recipes != null){
            for (Recipe recipe : recipes){
                if (MealTime.BRUNCH.toString().equalsIgnoreCase(recipe.getCategoryTime())){
                    filteredRecipes.add(recipe);
                }
            }
        }
        return filteredRecipes;
    }
}
