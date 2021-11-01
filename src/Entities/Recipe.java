package Entities;

import java.util.HashMap;

public class Recipe {

    private int recipeServings;
    private String title;
    private int prepTime;
    private String instructions;
    private HashMap<String, Float> ingredients;

    /**
     * Creates an instance of Entities.Food.Food
     * @param servings servings made per recipe
     * @param name recipe title
     * @param time time it takes to prepare recipe
     * @param steps steps to cook recipe
     * @param ingredients ingredients needed for recipe
     */
    public Recipe(int servings, String name, int time, String steps, HashMap<String, Float> ingredients) {
        this.recipeServings = servings;
        this.title = name;
        this.prepTime = time;
        this.instructions = steps;
        this.ingredients = ingredients;
    }

    public String addIngredients() {
        String it = "";
        for (String ingredient : this.ingredients.keySet()) {
            it += this.ingredients.get(ingredient) + " " + ingredient;
        }
        return it;
    }

    public String getTitle(){
        return this.title;
    }
    public String getServings(){
        return Integer.toString(this.recipeServings);
    }


    public HashMap<String, Float> getIngredients(){
        return this.ingredients;
    }

    public String getRecipe() {
        String servings = "\n Servings: " + Integer.toString(this.recipeServings);
        String prep = "\n Prep Time: " + Integer.toString(this.prepTime);
        String i = "\n Ingredients: \n" + this.addIngredients();
        String steps = "\n Steps: " + this.instructions;
        return this.title + "\n" + servings + prep + i + steps;
    }

}
