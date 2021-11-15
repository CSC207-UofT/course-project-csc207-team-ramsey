package constants;

import entities.Recipe;

public enum MealCountry {
    AMERICAN,
    ITALIAN,
    FRENCH,
    MEXICAN,
    CHINESE,
    JAPANESE,
    KOREAN;

    public static boolean matchIgnoreCase(String value){
        for (MealCountry mealCountry: MealCountry.values()){
            if(mealCountry.name().equalsIgnoreCase(value)){
                return true;
            }
        }
        return false;
    }

    public static boolean containsCategory(Recipe recipe) {

        for (MealCountry c :MealCountry.values()) {
            if (c.name().equalsIgnoreCase(recipe.getCategoryCountry())) {
                return true;
            }
        }

        return false;
    }
}