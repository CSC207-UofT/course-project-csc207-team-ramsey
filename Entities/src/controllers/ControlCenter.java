package controllers;

import Entities.Food;
import Entities.Recipe;
import Entities.User;
import use_cases.FoodManager;
import use_cases.RecipeManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class ControlCenter {

    public static String[] createUser(Scanner myObj) {

        System.out.println("Enter Name: ");

        String currName = myObj.nextLine();

        System.out.println("Enter Email: ");

        String currEmail = myObj.nextLine();

        System.out.println("Enter username: ");

        String currUser = myObj.nextLine();

        System.out.println("Enter password: ");
        myObj.nextLine();

        System.out.println("Welcome, " + currName);

        return new String[]{currUser, currName, currEmail};
    }

    public static String[] createFood(Scanner myObj) {
        System.out.println("Enter Name of Food: ");

        String foodName = myObj.nextLine();

        System.out.println("What is the shelf life: ");

        String shelfLife = myObj.nextLine();

        System.out.println("What is the unit: ");

        String unit = myObj.nextLine();

        System.out.println("What is the quantity: ");
        myObj.nextLine();

        String quantity = myObj.nextLine();

        return new String[]{foodName, quantity, shelfLife, unit};
    }

    public static String[] createRecipe(Scanner myObj) {
        System.out.println("""
                Please, input the following separated by commas:\s
                servings\s
                name\s
                time""");
        String csServeStep = myObj.nextLine();
        String[] serveStep = csServeStep.split(",");

        System.out.println("What are the instructions for your recipe?");
        String instructions = myObj.nextLine();

        System.out.println("What are is your list and quantity of ingredients. " +
                "\nPlease input in this format: \"ingrediant1:quantity1, ingrediant2:quantity2\"");
        String csIngredients = myObj.nextLine();
        String[] ingredients = csIngredients.split(",");

        return new String[]{serveStep[0], serveStep[1], serveStep[2], csIngredients, instructions};
    }

    public static void updateFood() {
    }

    public static void updateUser() {
    }

    public static void updateRecipe() {
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        RecipeManager rManager = new RecipeManager();
        FoodManager fManager = new FoodManager();

        ArrayList<Food> foodList = new ArrayList<Food>();
        ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
        ArrayList<Food> shoppingList = new ArrayList<Food>();

        String[] user_details = createUser(myObj);
        User user = new User(user_details[0], user_details[1], user_details[2], foodList, recipeList, shoppingList);

        while (true){
            System.out.println("""
                    Please, input one of the following commands:\s
                     -addNewFood\s
                     -displayFood\s
                     -addRecipe\s
                     -displayRecipes\s
                     -quit""");
            String command = myObj.nextLine();

            if (command.equals("addNewFood")){
                String[] food_details = createFood(myObj);
                fManager.makeNewFood(user, food_details[0], Integer.parseInt(food_details[1]), Integer.parseInt(food_details[2]), food_details[3]);

            } else if (command.equals("displayFood")){
                for (Food food : user.getFood()){
                    System.out.println(food.getName() + ": " + food.getQuantity());
                }
                System.out.println("\n");
            } else if (command.equals("addRecipe")){
                String[] recipe_details = createRecipe(myObj);

                String[] ingredients = recipe_details[3].split(",");

                HashMap<String, Float> hashMap
                        = new HashMap<String, Float>();


                String[] parts = recipe_details[3].split(",");


                for (String part : parts) {

                    String[] ingData = part.split(":");

                    String stuRollNo = ingData[0].trim();
                    Float stuName = Float.parseFloat(ingData[1].trim());

                    hashMap.put(stuRollNo, stuName);
                }
                Recipe newRecipe = new Recipe(Integer.parseInt(recipe_details[0]), recipe_details[1], Integer.parseInt(recipe_details[2]), recipe_details[4], hashMap);
                user.addRecipe(newRecipe);
            } else if (command.equals("displayRecipes")){
                for(Recipe recipe: recipeList){
                    System.out.println("=====" + recipe.getTitle() + "=====");
                    System.out.println("servings: " + recipe.getServings());

                    System.out.println("\n");
                }
            } else if(command.equals("quit")){
                System.exit(0);
            }

        }
    }
}
