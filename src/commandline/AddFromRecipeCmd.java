package commandline;

import controllers.ControlCentre;
import controllers.KitchenControlCentre;
import entities.food.Food;
import entities.Recipe;
import entities.User;
import usecases.FoodFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class AddFromRecipeCmd<T> extends Command<T> implements CommandExecute, FoodFactory {

    public AddFromRecipeCmd(T receiver) {
        super(5, 5, receiver);
    }

    public void initiate(Scanner s){
        System.out.println("Which recipe would you like to add food from?");
        String recipeName = s.nextLine();

        HashMap<String, Float> ingreds = ((KitchenControlCentre) receiver).getRecipeIngredients(recipeName, ((KitchenControlCentre) receiver).getUser());

        for (String ingredient : ingreds.keySet()) {
            System.out.println("This recipe requires " + ingredient + ".");
            System.out.println("What type of food is this (grains, meats, fruitvegi, dairy)?");
            String foodType = s.nextLine();

            System.out.println("What is the shelf life of this food?");
            String sl = s.nextLine();

            System.out.println("What is the unit (whole, ml, grams?) of this food?");
            String unit = s.nextLine();

            System.out.println("This recipe needs " + ingreds.get(ingredient) + " " + unit + " of " + ingredient + "." + "\n" +
                    " How much would you like to buy?");
            String quantity = s.nextLine();

            ArrayList<String> arguments = new ArrayList<>();
            arguments.add(foodType);
            arguments.add(ingredient);
            arguments.add(sl);
            arguments.add(quantity);
            arguments.add(unit);
        }

    }

    @Override
    public String execute(List<String> arguments) {

        try {
            int sl = Integer.parseInt(arguments.get(2));
            int quantity = Integer.parseInt(arguments.get(3));

            try {
                Food newFood = FoodFactory.getFood(arguments.get(0), arguments.get(1), sl, quantity, arguments.get(4));
                ((KitchenControlCentre) receiver).createFoodForList(arguments.get(0), arguments.get(1), sl, quantity, arguments.get(4));
                if (newFood == null) {
                    return "Your input is invalid";
                }
                return "Your food has been added to your shopping list.";
            } catch (Exception e) {
                return "Your input is invalid";
            }
        } catch (NumberFormatException e) {
            return "Your input is invalid";
        }
    }

}

