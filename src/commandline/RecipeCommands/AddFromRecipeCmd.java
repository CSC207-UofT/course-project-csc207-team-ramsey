package commandline.RecipeCommands;

import commandline.Command;
import commandline.CommandExecute;
import controllers.KitchenControlCentre;
import entities.food.Food;
import usecases.FoodFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;

public class AddFromRecipeCmd<T> extends Command<T> implements CommandExecute, FoodFactory {

    public AddFromRecipeCmd(T receiver) {
        super(10000, 5, receiver);
    }

    /**
     * initiate line call for AddFromRecipe Command
     * @param s a Scanner object to get input from user
     */
    public void initiate(Scanner s){
        System.out.println("Which recipe would you like to add food from?");
        String recipeName = s.nextLine();

        HashMap<String, Float> ingreds = ((KitchenControlCentre) receiver).getRecipeIngredients(recipeName, ((KitchenControlCentre) receiver).getUser());
        ArrayList<String> arguments = new ArrayList<>();

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

            arguments.add(foodType);
            arguments.add(ingredient);
            arguments.add(sl);
            arguments.add(quantity);
            arguments.add(unit);
        }

    }

    /**
     * execute AddFromRecipe
     * @param arguments is the input arguments for the AddFromRecipeCmd
     * @return String response message from command
     */
    @Override
    public String execute(List<String> arguments) {

        StringBuilder returnMessage = new StringBuilder();
        returnMessage.append("The following food has been added to your list: ");
        int x = arguments.size();
        int i = 0;
        while (i != x) {
            String type = arguments.get(i);
            i += 1;
            String name = arguments.get(i);
            i += 1;
            int sl = Integer.parseInt(arguments.get(i));
            i += 1;
            int quan = Integer.parseInt(arguments.get(i));
            i += 1;
            String foodUnit = arguments.get(i);
            Food newFood = ((KitchenControlCentre) receiver).createFoodForList(type, name, sl, quan, foodUnit);
            if (newFood == null) {
                return "Your input is invalid";
            } else {
                returnMessage.append("\n - " + name);
                }
            i += 1;
        }
        return returnMessage.toString();
    }

}