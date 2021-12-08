package commandline;

import constants.MealCountry;
import constants.MealTime;
import controllers.ControlCentre;
import controllers.RecipeControlCentre;


import java.util.*;

public class CreateRecipeCmd extends Command implements CommandExecute{
    public CreateRecipeCmd(ControlCentre receiver) {
        super(7, 7, receiver);
    }

    /**
     * initiate line call for CreateRecipeCmd
     * @param s is a Scanner object
     */
    public void initiate(Scanner s){
        do {
            String recipeTime = getRecipeTime(s);

            String recipeCategory = getCategory(s);

            System.out.println("What is the title of your recipe? ");
            String recipeTitle = s.nextLine();

            System.out.println("How long does it take to complete your recipe in minutes?: ");
            String time = s.nextLine();

            System.out.println("How many people can your recipe serve?: ");
            String servings = s.nextLine();

            String ingredients = parseIngredients(s);

            System.out.println("what are the instructions for your recipe?");
            String instructions = s.nextLine();

            ArrayList<String> arguments = new ArrayList<>();
            arguments.add(servings);
            arguments.add(recipeTitle);
            arguments.add(time);
            arguments.add(instructions);
            arguments.add(ingredients);
            arguments.add(recipeCategory);
            arguments.add(recipeTime);

            String response = execute(arguments);
            System.out.println(response);

            if (Objects.equals(response, "Your input is invalid")) {
                System.out.println("Would you like to try again(y/n)");
            } else {
                System.out.println("Would you like to add another recipe(y/n)");
            }

        } while (!Objects.equals(s.nextLine(), "n"));

    }

    /**
     * execute CreateRecipeCmd
     * @param arguments is the formatted input list from the user
     * @return String message for command
     */
    @Override
    public String execute(List<String> arguments) {
        RecipeControlCentre control = (RecipeControlCentre) this.receiver;
        try {
            int servings = Integer.parseInt(arguments.get(0));
            String name = arguments.get(1);

            int time = Integer.parseInt(arguments.get(2));
            String steps = arguments.get(3);
            HashMap<String, Float> ingredients = formatIngrDic(arguments.get(4));
            String categoryCountry = arguments.get(5);
            String categoryTime = arguments.get(6);

            try {
                control.createEntity(servings, name, time, steps, ingredients, categoryCountry, categoryTime);
                return "Your recipe has successfully been created";
            } catch (Exception e) {
                return "Your input is invalid";
            }
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            return "Your input is invalid";
        }
    }

    /**
     * helper method to format the formatted ingredients String to a HashMap
     * @param dicString is the parsed String from user ingredient inputs
     * @return HashMap of ingredients and quantity
     */
    private static HashMap<String, Float> formatIngrDic(String dicString){

        HashMap<String, Float> ingrDic = new HashMap<>();
        String[] dicList = dicString.split(",");

        for (String ingredient: dicList){
            String[] innerList = ingredient.split(":");
            ingrDic.put(innerList[0], Float.parseFloat(innerList[1]));
        }
        return ingrDic;
    }

    /**
     * helper method to get the MealTime category for the recipe
     * @param s is a Scanner object
     * @return String of ingredients and quantity
     */
    private static String getRecipeTime(Scanner s){
        System.out.println("What meal type is your recipe? (breakfast, brunch, lunch, dinner, dessert)?: ");

        boolean isRecipeTime = false;
        String recipeTime = null;

        while(!isRecipeTime){
            recipeTime = s.nextLine();
            if (MealTime.matchIgnoreCase(recipeTime)){
                isRecipeTime = true;
            } else {
                System.out.println("Sorry, we don't support that meal time. Please, try again.");
            }
        }
        return recipeTime;
    }

    /**
     * helper method to get the MealCountry category of the recipe
     * @param s is a scanner object
     * @return String for MealCountry category
     */
    private static String getCategory(Scanner s) {
        System.out.println("""
                Which of the following recipe categories is your recipe?:
                 - American
                 - Italian
                 - French
                 - Mexican
                 - Chinese
                 - Japanese
                 - Korean""");

        boolean isCategory = false;
        String category = null;
        while (!isCategory) {
            category = s.nextLine();
            if (MealCountry.matchIgnoreCase(category)) {
                isCategory = true;
            } else {
                System.out.println("Sorry, that is not a valid category.");
            }
        }
        return category;
    }

    /**
     * helper method to parse the ingredient input from user
     * @param s is a scanner object
     * @return String for ingredients and quanity
     */
    private static String parseIngredients(Scanner s){
        StringBuilder ingredients = new StringBuilder();
        System.out.println("""
                Please, input the ingredients for your recipe one at a time in the following format: ingredient:amount
                 The amount is measured with your unit of choice (i.e. mL for milk or grams for chicken)
                 Type "done" when you are finished.""");

        boolean done = false;
        while (!done){
            String ingredient = s.nextLine();
            ingredient = ingredient.replaceAll("\\s+",
                    "");
            if (ingredient.equals("done")){
                done = true;
            } else if (ingredients.isEmpty()){
                ingredients.append(ingredient);
            } else {
                ingredients.append(",");
                ingredients.append(ingredient);
            }
        }
        return ingredients.toString();

    }


}