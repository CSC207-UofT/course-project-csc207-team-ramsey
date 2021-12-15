package commandline;


import controllers.RecipeControlCentre;


import java.util.*;

public class EditRecipeDetailsCmd<T> extends Command<T> implements CommandExecute {

    public EditRecipeDetailsCmd(T receiver) {
        super(1, 1, receiver);
    }

    /**
     * execute EditRecipeDetailsCmd
     *
     * @param arguments is the formatted input list from the user
     * @return String message for command
     */
    @Override
    public String execute(List<String> arguments) {
        RecipeControlCentre recipeControlCentre = (RecipeControlCentre) this.receiver;
        if (arguments.size() == 3) {
            try {
                boolean success = recipeControlCentre.editRecipe(arguments.get(0), arguments.get(1), arguments.get(2));
                if (success) {
                    return arguments.get(0) + " was successfully edited.";
                } else {
                    return "That recipe could not be found.";
                }
            } catch (Exception e) {
                return "Your input may be invalid.";
            }
        } else {
            try {
                boolean success = recipeControlCentre.editRecipe(arguments.get(0), arguments.get(1), arguments.get(2), arguments.get(3), arguments.get(4));
                if (success) {
                    return arguments.get(0) + " was successfully edited.";
                } else {
                    return "That recipe could not be found.";
                }
            } catch (Exception e) {
                return "Your input may be invalid.";
            }
        }
    }

    /**
     * initiate line call for EditRecipeDetailsCmd
     *
     * @param s is a Scanner object
     */
    public void initiate(Scanner s) {
        RecipeControlCentre recipeControlCentre = (RecipeControlCentre) this.receiver;

        String[] options = new String[]{"name", "servings", "prep time", "instructions", "ingredients", "country category", "meal time category"};


        do {
            boolean executed = false;
            String result = "";

            System.out.println("Which recipe would you like to edit?");

            String recipeName = getValidRecipe(s, recipeControlCentre);
            if (recipeName.equals("none0")){
                return;
            }

            System.out.println("Which part of the recipe would you like to edit: ");

            for (String option : options) {
                System.out.println("-" + option);
            }

            ArrayList<String> arguments = new ArrayList<>();
            String recipeAttribute = getValidOption(s, options);

            if (recipeAttribute.equals("ingredients")) {
                System.out.println("Here are your current ingredients: ");
                for(Map.Entry<String, Float> entry: recipeControlCentre.getIngredientMap(recipeName).entrySet()){
                    System.out.println(entry.getKey() + ":" + entry.getValue().toString());
                }
                System.out.println("Which ingredient would you like to edit?");
                String ingredient = getValidIngredient(recipeName, s, recipeControlCentre);
                System.out.println("Please, input what you would like to change about the ingredient." +
                        "\n Use the following format to input the change: newIngredientName:newQuantity");
                String change = getValidIngrChange(s);
                arguments.add(recipeName);
                arguments.add(recipeAttribute);
                arguments.add(ingredient);
                String[] changeLst = change.strip().split(":");
                arguments.add(changeLst[0]);
                arguments.add(changeLst[1]);
                result = execute(arguments);
                executed = true;

            } else if (Arrays.asList(options).contains(recipeAttribute)) {
                System.out.println("Please, input what you would like to change the recipe " + recipeAttribute + " to?");
                String change = s.nextLine();
                arguments.add(recipeName);
                arguments.add(recipeAttribute);
                arguments.add(change);
                result = execute(arguments);
                executed = true;

            } else {
                System.out.println("That does not appear to be a recipe attribute. Would you like to try again(y/n)");
            }

            if (executed){
                if (result.equals("Your input may be invalid.")){
                    System.out.println("Would you like to try again(y/n)");
                } else {
                    System.out.println("Would you like to make another edit(y/n)");
                }

            }

        } while (s.nextLine().equals("y"));

    }

    /**
     * helper method to get valid attributes of recipe
     * @param s is a scanner object
     * @param options is a list of possible recipe parameters
     * @return String for a valid recipe attribute
     */
    private String getValidOption(Scanner s, String[] options){

        boolean success = false;
        String input = null;

        while (!success){
            input = s.nextLine();

            if (Arrays.asList(options).contains(input)){
                success = true;
            } else {
                System.out.println("The recipe attribute could not be recognized. Please, try again.");
            }
        }

        return input;

    }

    /**
     * get valid recipe from user
     * @param s a Scanner object
     * @param recipeControlCentre the RecipeControlCentre
     * @return a String which is valid recipe of user
     */
    private String getValidRecipe(Scanner s, RecipeControlCentre recipeControlCentre){

        boolean success = false;
        String recipe = null;
        while (!success){
            recipe = s.nextLine();
            if (!recipeControlCentre.checkRecipesNotEmpty()){
                System.out.println("No recipes available to edit. You have quit this command.");
                return "none0";
            }
            else if (recipeControlCentre.checkInKitchen(recipe)){
                success = true;
            } else {
                System.out.println("Recipe not found. Please, try again.");
            }
        }
        return recipe;
    }

    /**
     * get valid ingredient for a recipe of the user
     * @param recipeName is the name of the recipe
     * @param s is a Scanner object
     * @param recipeControlCentre is a RecipeControlCentre
     * @return STring which is a valid ingredient of the recipe
     */
    private String getValidIngredient(String recipeName, Scanner s, RecipeControlCentre recipeControlCentre){
        boolean success = false;
        String ingredient = null;
        while (!success){
            ingredient = s.nextLine();
            if (recipeControlCentre.checkIsIngredient(recipeName, ingredient)){
                success = true;
            } else {
                System.out.println("Ingredient not found. Please, try again.");
            }
        }
        return ingredient;
    }

    /**
     * get valid formatted change for ingredient
     * @param s is a Scanner object
     * @return String which is a valid ingredient change
     */
    private String getValidIngrChange(Scanner s){
        boolean success = false;
        String change = null;
        while (!success){
            change = s.nextLine();
            if (change.matches("^[a-zA-Z]+:+[0-9]+$")){
                success = true;
            } else {
                System.out.println("Input format does not match requested.");
            }
        }
        return change;
    }

}


