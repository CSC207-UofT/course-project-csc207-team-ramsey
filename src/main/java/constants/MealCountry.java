package constants;

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
}
