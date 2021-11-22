package constants;

import entities.Recipe;

public enum MealTime {
    BREAKFAST,
    BRUNCH,
    LUNCH,
    DINNER,
    DESSERT;

    public static boolean matchIgnoreCase(String value){
        for (MealTime mealTime: MealTime.values()){
            if(mealTime.name().equalsIgnoreCase(value)){
                return true;
            }
        }
        return false;
    }

    public static boolean containsCategory(Recipe recipe) {

        for (MealTime c :MealTime.values()) {
            if (c.name().equalsIgnoreCase(recipe.getCategoryTime())) {
                return true;
            }
        }

        return false;
    }
}
