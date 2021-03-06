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
     * @param user user adding new food
     * @param newFood new food being added to list
     * @return true if item was successfully added to list
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
     * @param user user buying food
     * @return true if items were successfully added
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
     * @param user user removing item
     * @param item item being removed from list
     * @return true if item was successfully deleted
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


    /**
     * Get recipe by title
     *
     * @param user user accessing recipe
     * @param recipeName title of recipe being accessed
     * @return recipe being accessed
     */
    public Recipe getRecipeFromTitle(User user, String recipeName) {
        for (Recipe recipe : user.getKitchen().getRecipes()) {
            if (recipe.getTitle().equals(recipeName)) {
                return recipe;
            }
        }
        return null;
    }

}
