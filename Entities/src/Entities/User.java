package Entities;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private String name;
    private String userName;
    private String email;
    private ArrayList<Food> food;
    public ArrayList<Recipe> recipes;
    private ArrayList<Food> shoppingList;

    /**
     * Creates an instance of Entities.User
     * @param user name of user
     * @param uName chosen user name for user
     * @param mail email associated with user
     */
    public User(String user, String uName, String mail) {
        this.userName = uName;
        this.name = user;
        this.email = mail;
        this.food = new ArrayList<Food>();
        this.recipes = new ArrayList<Recipe>();
        this.shoppingList = new ArrayList<Food>();
    }

    public String getUserName(){
        return this.userName;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Recipe> getRecipes(){
        return this.recipes;
    }

    public ArrayList<Food> getFood(){
        return this.food;
    }

    public ArrayList<Food> getList(){
        return this.shoppingList;
    }

    public void addFood(Food newFood){
        this.food.add(newFood);
    }


    public void addRecipe(Recipe newRecipe){
        this.recipes.add(newRecipe);
    }

    public void removeRecipe(int index){
        this.recipes.remove(index);
    }

}
