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

    public String getInfoQuantity(Food food){
        StringBuilder returnString = new StringBuilder();
        int count = 1;
        for (Map.Entry<String, String[]> entry : food.getDates().entrySet()){
            returnString.append(count).append(" - Bought Date: ").append(entry.getKey()).append(", Expiration Date: ").append(entry.getValue()[1]).append(", Quantity: ").append(entry.getValue()[0]).append("\n");
            count ++;
        }
        return returnString.toString();
    }

    public String getInfoFood(Food food){
        StringBuilder returnString = new StringBuilder();
        returnString.append("Food Name: ").append(food.getName()).append("\n").append("Shelf Life: ").append(food.getShelfLife()).append("\n").append("Quantity: ").append(food.getQuantity()).append("\n").append("Unit: ").append(food.getUnit());

        return returnString.toString();
    }

    public String removeQuantity(Food food, String quantity){
        if (food.getQuantity() < Integer.parseInt(quantity)) {
            StringBuilder returnString = new StringBuilder();
            returnString.append("You do not have: ").append(quantity).append(" ").append(food.getUnit()).append(" for ").append(food.getName());
            return returnString.toString();
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
                // food.getDates().get(keyVal)[0] = Integer.toString(entryQuantity - quantityFormatted);
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

    public Food findFood(String foodName, User user){
        for (Food food : user.getKitchen().getFood()){
            if (Objects.equals(food.getName(), foodName)){
                return food;
            }
        }
        return null;
    }

    public String updateFood(Food food, String updateField, String updateItem){
        if (updateField.equalsIgnoreCase("UNIT")){
            food.setUnit(updateItem);
        } else if (updateField.equalsIgnoreCase("SHELF LIFE")){
            food.setShelfLife(Integer.parseInt(updateItem));
        } else if (updateField.equalsIgnoreCase("FOOD NAME")){
            food.setName(updateItem);
        }
        return this.getInfoQuantity(food);
    }

    public String addFoodQuantity(Food food, String quantity){
        food.addQuantity(quantity);
        return this.getInfoQuantity(food);
    }

    public String addFoodtoList(Food food, Kitchen kitchen){
        kitchen.addFoodtoList(food);
        return kitchen.showKitchen().toString();
    }

    public String removeFoodfromList(Food food, Kitchen kitchen){
        kitchen.removeFoodfromList(food);
        return kitchen.showKitchen().toString();
    }

}






