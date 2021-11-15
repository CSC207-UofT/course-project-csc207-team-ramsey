package entities;
import java.util.HashMap;

/**
 * This class represents a Recipe which a User may want to make.
 * Recipes are stored in the User's Kitchen
 */
public class Recipe {

    private String title;
    private int recipeServings;
    private int prepTime;
    private String instructions;
    private HashMap<String, Float> ingredients;
    private String categoryCountry;
    private String categoryTime;

    /**
     * Creates an instance of Entities.Food.Food
     * @param name recipe title
     * @param servings servings made per recipe
     * @param time time it takes to prepare recipe
     * @param steps steps to cook recipe
     * @param ingredients ingredients needed for recipe
     * @param categoryCountry the category of the recipe by country
     * @param categoryTime the category of the recipe by time
     */
    public Recipe(int servings, String name, int time, String steps, HashMap<String, Float> ingredients, String categoryCountry, String categoryTime) {
        this.title = name;
        this.recipeServings = servings;
        this.prepTime = time;
        this.instructions = steps;
        this.ingredients = ingredients;
        this.categoryCountry = categoryCountry;
        this.categoryTime = categoryTime;

    }

    /**
     * @return current title
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * @return current servings
     */
    public String getServings(){
        return Integer.toString(this.recipeServings);
    }

    /**
     * @return current prepTime
     */
    public int getPrepTime(){
        return this.prepTime;
    }

    /**
     * @return current steps of recipe
     */
    public String getInstructions(){
        return this.instructions;
    }

    /**
     * @return current ingredients list
     */
    public HashMap<String, Float> getIngredients(){
        return this.ingredients;
    }
    /**
     * set the title
     * @param newTitle
     */
    public void setTitle(String newTitle){
        this.title = newTitle;
    }

    /**
     * set the servings
     * @param newServings
     */
    public void setServings(int newServings){
        this.recipeServings = newServings;
    }

    /**
     * set the prepTime
     * @param newPrepTime
     */
    public void setPrepTime(int newPrepTime){
        this.prepTime = newPrepTime;
    }

    /**
     * set the instructions
     * @param newInstructions
     */
    public void setInstructions(String newInstructions){
        this.instructions = newInstructions;
    }

    /**
     * set the ingredients
     * @param newIngredients
     */
    public void setIngredients(HashMap<String, Float> newIngredients){
        this.ingredients = newIngredients;
    }

    /**
     * helper method that returns a String representation of current ingredients
     * @return String ingredients
     */
    public String addIngredients() {
        String it = "";
        for (String ingredient : this.ingredients.keySet()) {
            it += this.ingredients.get(ingredient) + " " + ingredient;
        }
        return it;
    }

    /**
     * @return String representation of te recipe
     */
    public String toString() {
        String servings = "\n Servings: " + Integer.toString(this.recipeServings);
        String prep = "\n Prep Time: " + Integer.toString(this.prepTime);
        String i = "\n Ingredients: \n" + this.addIngredients();
        String steps = "\n Steps: " + this.instructions;
        return this.title + "\n" + servings + prep + i + steps;
    }

}
