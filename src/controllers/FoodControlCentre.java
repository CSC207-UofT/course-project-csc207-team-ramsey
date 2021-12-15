package controllers;

import entities.Kitchen;
import entities.User;
import entities.food.Food;
import usecases.FoodFactory;
import usecases.FoodManager;
import usecases.FoodSorter;

import java.util.Objects;

/**
 * This class is a controller class that takes the info from the commands and acts as a receiver to give the information back to the use cases
 */
public class FoodControlCentre{
    private final FoodManager foodManager;
    private final User user;
    private final FoodSorter foodSorter;

    /**
     * Constructor for the control centre for food
     * @param user the object that this class operates under
     */
    public FoodControlCentre(User user) {
        this.user = user;
        this.foodManager = new FoodManager();
        this.foodSorter = new FoodSorter();
    }

    /**
     *
     * @return the user
     */
    public User getUser(){
        return this.user;
    }

    /**
     * a helper function that helps search for a certain food
     * @param foodName the name of the food to be searched for
     * @param user the object that holds the array where foods are
     * @return food that has that name
     */
    public Food findFood(String foodName, User user){
        return this.foodManager.findFood(foodName, user);
    }

    /**
     * A class to create different foods
     * @param foodType the type of child class it will become
     * @param foodName name of the food
     * @param sl shelf life of the food
     * @param quantity initial quantity of the food
     * @param unit the unit the quantity is measured in
     * @return the new food
     */
    public Food createEntity(String foodType, String foodName, int sl, int quantity, String unit){
        Food newFood = FoodFactory.getFood(foodType, foodName, sl, quantity, unit);
        this.getUser().getKitchen().addFoodtoList(newFood);
        return newFood;
    }

    /**
     * a helper function that adds food to the list in kitchen
     * @param food the new food being added
     * @param kitchen the object where the array list is located
     */
    public void addFoodToList(Food food, Kitchen kitchen){
        this.foodManager.addFoodToList(food, kitchen);
    }

    /**
     * a function that is used in the showfood command for users to see details of their food
     * @param food the food that will be displayed
     * @return a string that represents the details of that food
     */
    public String showFood(String food, User user){
        if (this.findFood(food, user) != null) {
            return foodManager.getInfoFood(this.findFood(food, user)) + "\n" + foodManager.getInfoQuantity(this.findFood(food, user));
        } else {
            return "This food does not exist";
        }
    }

    /**
     * this function removes a certain amount from the food
     *
     * @param foodName the name of the food
     * @param quantity the amount to be subtracted
     * @param user the user that contains the kitchen that contains the array for the foods
     * @return a string that represents the quantity of food
     */
    public String removeFoodQuantity(String foodName, String quantity, User user){
        if (this.findFood(foodName, user) != null) {
            return this.foodManager.removeQuantity(this.findFood(foodName, user), quantity);
        } else {
            return "This food does not exist";
        }
    }

    /**
     * A function that updates a food
     * @param foodName the name of the food that needs to be updated
     * @param updateField the field (shelf life, unit or name)
     * @param updateItem the value that will replace the old value
     * @param user where the food is stored
     * @return a string that represents the food after its been updated
     */
    public String updateFood(String foodName, String updateField, String updateItem, User user){
        if (this.findFood(foodName, user) != null) {
            return this.foodManager.updateFood(this.findFood(foodName, user), updateField, updateItem);
        } else {
            return "This food does not exist";
        }
    }

    /**
     * a function that adds an amount of the food
     * @param foodName the name of the food that the quantity will be added to
     * @param quantity the amount that will be added to food
     * @param user the place where food is stored
     * @return a string that represents the quantity of the food
     */
    public String addFoodQuantity(String foodName, String quantity, User user){
        if (this.findFood(foodName, user) != null) {
            return this.foodManager.addFoodQuantity(this.findFood(foodName, user), quantity);
        } else {
            return "This food does not exist";
        }
    }

    /**
     * this function removes food from the list of foods
     * @param foodName the name of the food that will be removed
     * @param user the place where the food is stored
     * @return a string that represents the list of foods in the kitchen from user
     */
    public String deleteEntity(String foodName, User user) {
        Food food = this.findFood(foodName, user);
        if (food != null) {
            return this.foodManager.removeFoodFromList(food, user.getKitchen());
        } else {
            return "This food does not exist";
        }
    }

    /**
     * This function takes the type and returns a string tht represents the foods with that type
     * @param user where the food is stored
     * @param type the type of food that is to be searched for
     * @return a string that represents the list of foods
     */
    public String sortByCategory(User user, String type){
        if (Objects.equals(this.foodSorter.sortByCategory(user.getKitchen(), type), "")){
            return "There are no foods matching that category";
        } else{
            return this.foodSorter.sortByCategory(user.getKitchen(), type);
        }
    }

    /**
     * This function sorts all the foods in user by their expiration dates
     * @param user the place where foods are stored
     * @return a string that represents the list of foods
     */
    public String sortByExpiration(User user){
        if (Objects.equals(this.foodSorter.sortByExpiration(user.getKitchen()), "")){
            return "There are no foods matching that category";
        } else{
            return this.foodSorter.sortByExpiration(user.getKitchen());
        }
    }

}
