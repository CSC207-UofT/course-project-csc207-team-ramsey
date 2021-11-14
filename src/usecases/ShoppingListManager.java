package usecases;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import entities.Recipe;
import entities.User;
import entities.food.Food;
import entities.Kitchen;
import usecases.FoodFactory;
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
                           // String type, String name, int quantity, int shelfLife, String unit) {
        ArrayList<Food> shoppingList = user.getKitchen().getShoppingList();
        Kitchen kitchen = user.getKitchen();

        // Food newFood = FoodFactory.getFood(type, name, shelfLife, quantity, unit);

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

    /**
     * Return unowned ingredients from a recipe
     *
     * @param user
     * @param recipe
     * @return true if items were successfully added
     */

    public HashMap<String, Float> getRecipeFood(User user, Recipe recipe) {
        HashMap<String, Float> ingredients = recipe.getIngredients();
        HashMap<String, Float> newFoods = new HashMap<String, Float>();

        for (String food : recipe.getIngredients().keySet()) {
            for (Food kitchenFood : user.getKitchen().getFood()) {
                if (kitchenFood.getName() == food && kitchenFood.getQuantity() < ingredients.get(food)) {
                    newFoods.put(food, ingredients.get(food));
                }
            }
        }
        return newFoods;
    }

//    public boolean addFromRecipe(User user, Recipe recipe) {
//        ArrayList<Food> shoppingList = user.getKitchen().getShoppingList();
//        Kitchen kitchen = user.getKitchen();
//        HashMap<String, Float> ingredients = recipe.getIngredients();
//        // iterate through recipe ingredients
//        for (String food : recipe.getIngredients().keySet()) {
//            boolean newFood = true;
//            // check if ingredient is in kitchen
//            for (Food kitchenFood : user.getKitchen().getFood()) {
//                // if food is in kitchen, make another instance for shopping list
//                if (kitchenFood.getName() == food) {
//                    newFood = false;
//                    int quantity = Math.round(ingredients.get(food));
//                    Food addFood = FoodFactory.getFood(kitchenFood.getType(), food, kitchenFood.getShelfLife(), quantity, kitchenFood.getUnit());
//                    shoppingList.add(addFood);
//                }
//            }
//            if (newFood) {
//                // false indicates food is new, ask user to enter an associated unit, type, and shelflife
//                this.unfoundList.add(food);
//            }

//            }
//            kitchen.setShoppingList(shoppingList);
//            user.setKitchen(kitchen);
//
//        }
//        return true;
//    }
//
//    public ArrayList<String> getUnused() {
//        return this.unfoundList;
//    }
//
//}
}


