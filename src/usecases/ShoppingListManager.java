package usecases;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import entities.User;
import entities.Recipe;
import entities.food.Food;
import entities.Kitchen;
import java.time.LocalDateTime;

/**
 * Represents a ShoppingList to track what food to buy and how much
 */


public class ShoppingListManager {

    /**
     * Add item to shoppingList, or update quantity needed if item is already in list
     * @param user
     * @param newFood
     * @return true if item was successfully added to list
     */
    public boolean addFood(User user, Food newFood) {

        ArrayList<Food> shoppingList = user.getKitchen().getShoppingList();
        Kitchen kitchen = user.getKitchen();

        // check if food is already in list
        for (Food food : shoppingList) {
            if (food.getName() == newFood.getName()) {
                int quan = food.getQuantity();
                // if food is already in list, update quantity needed
                quan += newFood.getQuantity();
                LocalDateTime buyDate = LocalDateTime.now();
                DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String formattedBuy = buyDate.format(formatObj);
                food.setQuantity(formattedBuy, Integer.toString(quan));
                kitchen.setShoppingList(shoppingList);
                user.setKitchen(kitchen);
                return user.getKitchen().getShoppingList().contains(newFood) && newFood.getQuantity() == quan;
            }
        }

        if (!user.getKitchen().getShoppingList().contains(newFood)) {
            shoppingList.add(newFood);
            user.getKitchen().setShoppingList(shoppingList);
        }

        return user.getKitchen().getShoppingList().contains(newFood);
    }

    /**
     * Add all food from shoppingList into FoodManager
     *
     * @param user
     * @return true if items were successfully added
     */
    public boolean buyAllFood(User user) {
        ArrayList<Food> shoppingList = user.getKitchen().getShoppingList();
        Kitchen kitchen = user.getKitchen();
        for (Food item : user.getKitchen().getShoppingList()) {
            ArrayList<Food> food = user.getKitchen().getFood();
            food.add(item);
            shoppingList.remove(item);
            kitchen.setShoppingList(shoppingList);
            if (user.getKitchen().getShoppingList().contains(item)) {
                return false;
            }
            kitchen.setFood(food);
            user.setKitchen(kitchen);
        }
        return true;
    }

    /**
     * Remove item from shoppingList
     *
     * @param user
     * @param item
     * @return true if item was successfully deleted
     */

    public boolean deleteItem(User user, Food item) {
        ArrayList<Food> shoppingList = user.getKitchen().getShoppingList();
        Kitchen kitchen = user.getKitchen();
        if (shoppingList.contains(item)) {
            shoppingList.remove(item);
            kitchen.setShoppingList(shoppingList);
            user.setKitchen(kitchen);
        }
        return (user.getKitchen().getShoppingList().contains(item));
    }

    public Recipe getRecipeFromTitle(User user, String recipeName) {
        for (Recipe recipe : user.getKitchen().getRecipes()) {
            if (recipe.getTitle().equals(recipeName)) {
                return recipe;
            }
        }
        return null;
    }

}


