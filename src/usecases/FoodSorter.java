package usecases;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import entities.Kitchen;
import entities.food.*;

public class FoodSorter  {

    /**
     * this function takes the food array list from kitchen and sorts it by the expiration date that comes first
     * @param kitchen the object that contains the food arraylist
     * @return a string to represent the foods
     */
    public String sortByExpiration(Kitchen kitchen){
        Hashtable<LocalDate, Food> dataDict = new Hashtable<>();
        ArrayList<LocalDate> foodEarliestDates = new ArrayList<>();
        for (Food food: kitchen.getFood()){
            LocalDate earliestDate = food.getEarliestDate();
            dataDict.put(earliestDate, food);
            foodEarliestDates.add(earliestDate);
        }

        Collections.sort(foodEarliestDates);

        ArrayList<String> returnList = new ArrayList<>();
        for (LocalDate earliestDate: foodEarliestDates){
            Food food = dataDict.get(earliestDate);
            DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedBuy = earliestDate.format(formatObj);

            returnList.add(food.getName() + ": " + food.getDates().get(formattedBuy)[0] + " " + food.getUnit() + "expires on " + food.getDates().get(formattedBuy)[1]);
        }

        StringBuilder returnString = new StringBuilder();
        for (String entry: returnList){
            returnString.append(entry).append("\n");
        }

        return returnString.toString();
    }

    /**
     * this function sorts the food by the category given
     * @param kitchen the object that contains the food array list
     * @param type the type of food the user wants
     * @return all the foods that match the category
     */
    public String sortByCategory(Kitchen kitchen, String type){
        ArrayList<Food> categoryFood = new ArrayList<>();

        for (Food food: kitchen.getFood()) {
            if (type.equalsIgnoreCase("Grains")) {
                if (food instanceof Grains) {
                    categoryFood.add(food);
                }
            } else if (type.equalsIgnoreCase("FruitVegi")) {
                if (food instanceof FruitVegi) {
                    categoryFood.add(food);
                }
            } else if (type.equalsIgnoreCase("Meats")) {
                if (food instanceof Meat) {
                    categoryFood.add(food);
                }
            } else if (type.equalsIgnoreCase("SoupsCond")) {
                if (food instanceof SoupsCond) {
                    categoryFood.add(food);
                }
            } else {
                return "That category does not exist";
            }
        }
        FoodManager foodManager = new FoodManager();
        StringBuilder returnString = new StringBuilder();
        for (Food food : categoryFood){
            returnString.append(foodManager.getInfoFood(food)).append("\n");
        }

        return returnString.toString();
    }
}
