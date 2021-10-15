import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {

    private String name;
    private String userName;
    private String email;
    private ArrayList<Food> food;
    private ArrayList<Recipe> recipes;
    private ArrayList<Food> shoppingList;

    /**
     * Creates an instance of Food
     * @param user name of user
     * @param uName chosen user name for user
     * @param mail email associated with user
     * @param uFood food belonging to user
     * @param uRecipes recipes of user
     * @param list shopping list for user
     */
    public User(String user, String uName, String mail, ArrayList<Food> uFood, ArrayList<Recipe> uRecipes, ArrayList<Food> list) {
        this.userName = uName;
        this.name = user;
        this.email = mail;
        this.food = uFood;
        this.recipes = uRecipes;
        this.shoppingList = list;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Recipe> getRecipes(){
        return this.recipes;
    }

    public ArrayList<Food> getFood(){
        return this.food;
    }

    public ArrayList<Food> getList(){
        return this.shoppingList;
    }
}
