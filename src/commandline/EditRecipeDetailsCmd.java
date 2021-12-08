package commandline;

import controllers.ControlCentre;
import controllers.RecipeControlCentre;

import java.util.*;

public class EditRecipeDetailsCmd extends Command implements CommandExecute{

    public EditRecipeDetailsCmd(ControlCentre receiver) {
        super(1, 1, receiver);
    }

    /**
     * execute EditRecipeDetailsCmd
     * @param arguments is the formatted input list from the user
     * @return String message for command
     */
    @Override
    public String execute(List<String> arguments) {
        RecipeControlCentre recipeControlCentre = (RecipeControlCentre) this.receiver;
        if (arguments.size() == 3){
            try{
                Boolean success = recipeControlCentre.editRecipe(arguments.get(0), arguments.get(1), arguments.get(2));
                if (success){
                    return arguments.get(0) + " was successfully changed.";
                } else {
                    return "That recipe could not be found.";
                }
            } catch(Exception e) {
                return "Your input may be invalid.";
            }
        } else {

        }

    }

    /**
     * initiate line call for EditRecipeDetailsCmd
     * @param s is a Scanner object
     */
    public void initiate(Scanner s){

        String cont = null;
        String[] options = new String[]{"name", "servings", "prep time", "instructions","ingredients", "country category", "meal time category"};

        do{
            System.out.println("Which recipe would you like to edit?");
            String recipeName = s.nextLine();
            System.out.println("Which part of the recipe would you like to edit: ");

            for(String option : options){
                System.out.println("-" + option);
            }

            ArrayList<String> arguments = new ArrayList<>();
            String variable = s.nextLine();

            if (variable.equals("ingredients")){
                System.out.println("Which ingredient would you like to change?");
                String ingredient = s.nextLine();
                System.out.println("What would you like to change the ingredient to?");
                String change = s.nextLine();
                arguments.add(recipeName);
                arguments.add(ingredient);
                arguments.add(variable);
                arguments.add(change);
                execute(arguments);

            } else if (Arrays.asList(options).contains(variable)){
                System.out.println("What would you like to change the recipe " + variable + "to?");
                String change = s.nextLine();
                arguments.add(recipeName);
                arguments.add(variable);
                arguments.add(change);
                execute(arguments);

            } else {
                System.out.println("That does not appear to be a recipe attribute. Would you like to try again(y/n)");
                cont = s.nextLine();
            }


        } while (!Objects.equals(cont, "y"));

    }
}
