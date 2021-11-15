package usecases;

import entities.food.*;

public interface FoodFactory {

    public static Food getFood(String foodType, String foodName, int sl, int quantity, String unit){
        if(foodType == null){
            return null;
        }
        if(foodType.equalsIgnoreCase("GRAINS")) {
            return new Grains(sl, foodName, quantity, unit);
        }
        else if(foodType.equalsIgnoreCase("MEATS")){
            return new Meat(sl, foodName, quantity, unit);
        }
        else if(foodType.equalsIgnoreCase("FRUITVEGI")) {
            return new FruitVegi(sl, foodName, quantity, unit);
        }
        else if(foodType.equalsIgnoreCase("DAIRY")) {
            return new Dairy(sl, foodName, quantity, unit);
        }
        return null;
    }
}//end of GetPlanFactory class.

