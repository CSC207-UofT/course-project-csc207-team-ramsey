package constants;

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
}
