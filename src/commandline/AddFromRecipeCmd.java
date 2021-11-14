package commandline;

import controllers.ControlCentre;
import controllers.ShoppingListControlCentre;
import entities.food.Food;
import entities.Recipe;
import usecases.FoodFactory;
import usecases.ShoppingListManager;


import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import java.util.Scanner;

public class AddFromRecipeCmd extends Command implements CommandExecute, FoodFactory {

    public AddFromRecipeCmd(ControlCentre receiver) {
        super(5, 5, receiver);
    }

    public void createFoodLineCall(Scanner s, Recipe recipe) {

        HashMap<String, Float> recipeIngredients = recipe.getIngredients();

        for (String foodName : recipeIngredients.keySet()) {
            System.out.println("This recipe requires " + foodName + ".");
            System.out.println("What type of food is this (grains, meats, fruitvegi, dairy)?: ");
            String foodType = s.nextLine();

            System.out.println("What is the shelf life of this food?: ");
            String sl = s.nextLine();

            System.out.println("What is the unit (whole, ml, grams?) of this food?: ");
            String unit = s.nextLine();

            System.out.println("This recipe needs " + recipeIngredients.get(foodName) + " " + unit + " of " + foodName + "." + "\n" +
                    " How much would you like to buy?: ");
            String quantity = s.nextLine();

            ArrayList<String> arguments = new ArrayList<String>();
            arguments.add(foodType);
            arguments.add(foodName);
            arguments.add(sl);
            arguments.add(quantity);
            arguments.add(unit);

            String response = execute(this.receiver, arguments);
            System.out.println(response);

        }

    }

    @Override
    public String execute(ControlCentre receiver, List<String> arguments) {
        ShoppingListControlCentre kitchenControl = (ShoppingListControlCentre) receiver;
        try {
            int sl = Integer.parseInt(arguments.get(2));
            int quantity = Integer.parseInt(arguments.get(3));

            try {
                Food newFood = FoodFactory.getFood(arguments.get(0), arguments.get(1), sl, quantity, arguments.get(4));
                kitchenControl.createFoodForList(arguments.get(0), arguments.get(1), sl, quantity, arguments.get(4));
                if (newFood == null) {
                    return "Your input is invalid";
                }
                return "Your food has been added";
            } catch (Exception e) {
                return "Your input is invalid";
            }
        } catch (NumberFormatException e) {
            return "Your input is invalid";
        }
    }


}

