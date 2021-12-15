package usecases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

import entities.Kitchen;
import entities.User;
import entities.food.Food;

public class FoodManager {

    /**
     * This function returns a string of the bought date, expiration date, and quantities of a food
     * @param food food object that is to be read
     * @return a string that represents the object food's quantities
     */
    public String getInfoQuantity(Food food){
        StringBuilder returnString = new StringBuilder();
        int count = 1;
        for (Map.Entry<String, String[]> entry : food.getDates().entrySet()){
            returnString.append(count).append(" - Bought Date: ").append(entry.getKey()).append(", Expiration Date: ").append(entry.getValue()[1]).append(", Quantity: ").append(entry.getValue()[0]).append("\n");
            count ++;
        }
        return returnString.toString();
    }

    /**
     * this function returns a string of the food info like unit, shelf life and name
     * @param food the object that is evaluated
     * @return a string that represents the object food
     */
    public String getInfoFood(Food food){

        return "Food Name: " + food.getName() + "\n" + "Shelf Life: " + food.getShelfLife() + "\n" + "Quantity: " + food.getQuantity() + "\n" + "Unit: " + food.getUnit();
    }

    /**
     * this function removes a quantity from the food object
     * @param food the object the quantity is being removed from
     * @param quantity the amount being removed
     * @return a string that represents the rest of the quantities
     */
    public String removeQuantity(Food food, String quantity){
        if (food.getQuantity() < Integer.parseInt(quantity)) {
            return "You do not have: " + quantity + " " + food.getUnit() + " for " + food.getName();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ArrayList<LocalDate> data = new ArrayList<>();
        for (Map.Entry<String, String[]> entry : food.getDates().entrySet()){
            LocalDate dateTime = LocalDate.parse(entry.getKey(), formatter);
            data.add(dateTime);
        }
        Collections.sort(data);
        int quantityFormatted = Integer.parseInt(quantity);

        for (LocalDate buyDate : data) {
            String keyVal = buyDate.format(formatter);
            int entryQuantity = Integer.parseInt(food.getDates().get(keyVal)[0]);
            if (entryQuantity > quantityFormatted){
                food.setQuantity(keyVal, Integer.toString(entryQuantity - quantityFormatted));
                return this.getInfoQuantity(food);
            } else if (entryQuantity == quantityFormatted){
                food.removeEntry(keyVal);
                return this.getInfoQuantity(food);
            } else {
                quantityFormatted = quantityFormatted - entryQuantity;
                food.removeEntry(keyVal);
            }

        }
        return this.getInfoQuantity(food);

    }

    /**
     * A helper function used to find a certain food by its name
     * @param foodName the name of the food
     * @param user where to look for the kitchen that contains the list of foods
     * @return food object
     */
    public Food findFood(String foodName, User user){
        for (Food food : user.getKitchen().getFood()){
            if (Objects.equals(food.getName(), foodName)){
                return food;
            }
        }
        return null;
    }

    /**
     * This function updates a food based on the field they want updated
     * @param food the object being updated
     * @param updateField the field (unit, shelf life or food name)
     * @param updateItem the item that will replace either unit, shelf life or food name
     * @return the updated information on the food
     */
    public String updateFood(Food food, String updateField, String updateItem){
        if (updateField.equalsIgnoreCase("UNIT")){
            food.setUnit(updateItem);
        } else if (updateField.equalsIgnoreCase("SHELF LIFE")){
            food.setShelfLife(Integer.parseInt(updateItem));
        } else if (updateField.equalsIgnoreCase("FOOD NAME")){
            food.setName(updateItem);
        }
        return this.getInfoFood(food);
    }

    /**
     * this function adds an amount/ entry to the food
     * @param food the object that is getting added to
     * @param quantity the amount that will be added
     * @return the quantity descriptions of the food
     */
    public String addFoodQuantity(Food food, String quantity){
        food.addQuantity(quantity);
        return this.getInfoQuantity(food);
    }

    /**
     * this function is a helper function that adds a new food to the list of foods in kitchen
     * @param food the object that will be added
     * @param kitchen the object that contains the list of foods to be added to
     */
    public void addFoodToList(Food food, Kitchen kitchen){
        kitchen.addFoodtoList(food);
        kitchen.showKitchen();
    }

    /**
     * this function removes a food from the kitchen
     * @param food the food that will be removed
     * @param kitchen the object containing the list that it will be removed from
     * @return a description of the kitchen
     */
    public String removeFoodFromList(Food food, Kitchen kitchen){
        kitchen.removeFoodfromList(food);
        return kitchen.showKitchen().toString();
    }

}






