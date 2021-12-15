package commandline.KitchenShoppingListCommands;

import commandline.Command;
import commandline.CommandExecute;
import controllers.KitchenControlCentre;
import entities.food.Food;
import entities.Kitchen;
import usecases.FoodFactory;

import java.util.*;

public class BuyFoodFromListCmd<T> extends Command<T> implements CommandExecute, FoodFactory {

    public BuyFoodFromListCmd(T receiver) {
        super(0, 0, receiver);
    }

    /**
     * execute BuyFoodFromList
     * @param arguments is the input arguments for the BuyFoodFromList Command
     * @return String response message from command
     */
    @Override
    public String execute(List<String> arguments) {
        if (arguments.get(0) == "YES") {
            ArrayList<Food> shoppingList = ((KitchenControlCentre) receiver).getUser().getKitchen().getFood();
            Kitchen kitchen = ((KitchenControlCentre) receiver).getUser().getKitchen();
            StringBuilder response = new StringBuilder();

            if (shoppingList == null || shoppingList.isEmpty()) {
                return "You currently have no items in your list.";
            } else {
                for (Food food : shoppingList) {
                    kitchen.addFoodtoList(food);
                    shoppingList.remove(food);
                    response.append("\n" + food.getName());
                }
                return "The following food has been added to your kitchen: " + response;
            }
        } else {
            return "Ok, return to the main menu";
        }
    }


    /**
     * initiate line call for BuyFoodFromList Command
     * @param s a Scanner object to get input from user
     */
    @Override
    public void initiate(Scanner s) {
        System.out.println("Would you like to add your Shopping List food to your kitchen?");
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
