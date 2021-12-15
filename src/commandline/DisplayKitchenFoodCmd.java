package commandline;

import controllers.KitchenControlCentre;
import entities.food.Food;
import usecases.FoodFactory;

import java.util.*;

public class DisplayKitchenFoodCmd<T> extends Command<T> implements CommandExecute, FoodFactory {

    public DisplayKitchenFoodCmd(T receiver) {
        super(0, 0, receiver);
    }

    /**
     * execute DisplayKitchenFood
     * @param arguments is the input arguments for the DisplayKitchenFood Command
     * @return String response message from command
     */
    @Override
    public String execute(List<String> arguments) {
        if (arguments.get(0) == "YES") {
            ArrayList<Food> foodList = ((KitchenControlCentre) receiver).getUser().getKitchen().getFood();

            if (foodList == null || foodList.isEmpty()) {
                return "You currently have no food in your kitchen.";
            } else {
                StringBuilder foods = new StringBuilder();
                foods.append("You currently have the following food in your kitchen: " + "\n");
                return ((KitchenControlCentre) receiver).getFoodList(((KitchenControlCentre) receiver).getUser()).toString();
            }
        } else {
            return "Ok, return to the main menu";
        }
    }


    /**
     * initiate line call for DisplayKitchenFood Command
     * @param s a Scanner object to get input from user
     */
    @Override
    public void initiate(Scanner s) {
        System.out.println("Would you like to see all of the food in your kitchen? Input 'YES' or 'NO'.");
        String response = s.nextLine();
        List<String> args = new ArrayList<>();
        if (response.equals("YES") || response.equals("NO")){
            args.add(response);
            System.out.println(execute(args));
        } else {
            System.out.println("I'm sorry, that response is invalid. Please, try again.");
        }
    }
}
