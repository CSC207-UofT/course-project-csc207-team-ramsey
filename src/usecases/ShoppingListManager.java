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
     */
    public void addFood(User user, Food newFood) {

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
                if (user.getKitchen().getShoppingList().contains(newFood)) {
                    newFood.getQuantity();
                }
                return;
            }
        }

        if (!user.getKitchen().getShoppingList().contains(newFood)) {
            shoppingList.add(newFood);
            user.getKitchen().setShoppingList(shoppingList);
        }

    }

    /**
     * Add all food from shoppingList into FoodManager
     *
     * @param user
     */
    public void buyAllFood(User user) {
        ArrayList<Food> shoppingList = user.getKitchen().getShoppingList();
        Kitchen kitchen = user.getKitchen();
        for (Food item : user.getKitchen().getShoppingList()) {
            ArrayList<Food> food = user.getKitchen().getFood();
            food.add(item);
            shoppingList.remove(item);
            kitchen.setShoppingList(shoppingList);
            if (user.getKitchen().getShoppingList().contains(item)) {
                return;
            }
            kitchen.setFood(food);
            user.setKitchen(kitchen);
        }
    }

    /**
     * Remove item from shoppingList
     *
     * @param user
     * @param item
     */

    public void deleteItem(User user, Food item) {
        ArrayList<Food> shoppingList = user.getKitchen().getShoppingList();
        Kitchen kitchen = user.getKitchen();
        if (shoppingList.contains(item)) {
            shoppingList.remove(item);
            kitchen.setShoppingList(shoppingList);
            user.setKitchen(kitchen);
        }
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
