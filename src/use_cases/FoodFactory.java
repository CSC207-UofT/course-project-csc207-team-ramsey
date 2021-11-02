package use_cases;

import Entities.Food.*;

public interface FoodFactory {

    public default Food getFood(String foodType){
        if(foodType == null){
            return null;
        }
        if(foodType.equalsIgnoreCase("GRAINS")) {
            return new Grains();
        }
        else if(foodType.equalsIgnoreCase("MEATS")){
            return new Meat();
        }
        else if(foodType.equalsIgnoreCase("FRUITVEGI")) {
            return new FruitVegi();
        }
        else if(foodType.equalsIgnoreCase("DAIRY")) {
            return new Dairy();
        }
        return null;
    }
}//end of GetPlanFactory class.

