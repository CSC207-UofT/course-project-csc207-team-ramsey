package usecases;

import entities.food.*;

/**
 * a factory class interface that helps make foods depending on the type of food
 */
public interface FoodFactory {

    /**
     *
     * @param foodType the type of food (grains, meats etc)
     * @param foodName the name of the new food created
     * @param sl the shelf life of the food
     * @param quantity the initial quantity of the food
     * @param unit the unit that the quantity is measured in
     * @return a new food
     */
    static Food getFood(String foodType, String foodName, int sl, int quantity, String unit){
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
        else if(foodType.equalsIgnoreCase("SOUPSCOND")) {
            return new SoupsCond(sl, foodName, quantity, unit);
        }
        return null;
    }
}//end of GetPlanFactory class.

