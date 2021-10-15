package controllers;

import Entities.Food;
import Entities.Recipe;
import Entities.User;
import use_cases.FoodManager;
import use_cases.RecipeManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ControlCenter {


    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        RecipeManager rManager = new RecipeManager();
        FoodManager fManager = new FoodManager();

        ArrayList<Food> foodList = new ArrayList<Food>();
        ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
        ArrayList<Food> shoppingList = new ArrayList<Food>();
        User user = new User("Bob", "Bob", "bob@user.ca", foodList, recipeList, shoppingList);
        System.out.println("Enter username: ");

        String currUser = myObj.nextLine();

        System.out.println("Enter password: ");
        myObj.nextLine();

        System.out.println("Welcome, " + currUser);


        while (true){
            System.out.println("Please, input one of the following commands: \n -addNewFood \n -displayFood \n -addRecipe " +
                    "\n -displayRecipes \n -quit");
            String command = myObj.nextLine();
            if (command.equals("addNewFood")){
                System.out.println("Please, input the name, quantity, and shelflife or your new food separated by commas.");
                String csFoodData = myObj.nextLine();

                String[] values = csFoodData.split(",");
                fManager.makeNewFood(user, values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]));

            } else if (command.equals("displayFood")){
                for (Food food : user.getFood()){
                    System.out.println(food.getName() + ": " + food.getQuanity());
                }
                System.out.println("\n");
            } else if (command.equals("addRecipe")){
                System.out.println("Please, input the following separated by commas: " +
                        "\nservings " +
                        "\nname " +
                        "\ntime");
                String csServeStep = myObj.nextLine();
                String[] serveStep = csServeStep.split(",");

                System.out.println("What are the instructions for your recipe?");
                String instructions = myObj.nextLine();

                System.out.println("What are is your list and quantity of ingredients. " +
                        "\nPlease input in this format: \"ingrediant1:quantity1, ingrediant2:quantity2\"");
                String csIngredients = myObj.nextLine();
                String[] ingredients = csIngredients.split(",");



                HashMap<String, Float> hashMap
                        = new HashMap<String, Float>();


                String[] parts = csIngredients.split(",");


                for (String part : parts) {

                    String[] ingData = part.split(":");

                    String stuRollNo = ingData[0].trim();
                    Float stuName = Float.parseFloat(ingData[1].trim());

                    hashMap.put(stuRollNo, stuName);
                }
                Recipe newRecipe = new Recipe(Integer.parseInt(serveStep[0]), serveStep[1], Integer.parseInt(serveStep[2]), instructions, hashMap);
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
