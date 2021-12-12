package commandline;

import controllers.ControlCentre;
import controllers.KitchenControlCentre;
import entities.User;
import entities.food.Food;
import usecases.FoodFactory;

import java.util.*;

public class DisplayShoppingListCmd<T> extends Command<T> implements CommandExecute, FoodFactory {

    public DisplayShoppingListCmd(T receiver) {
        super(0, 0, receiver);
    }

    @Override
    public String execute(List<String> arguments) {
        if (arguments.get(0) == "YES") {

            ArrayList<Food> shoppingList = ((KitchenControlCentre) receiver).getUser().getKitchen().getShoppingList();

            if (shoppingList == null || shoppingList.isEmpty()) {
                return "You currently have no food in your shopping list.";
            } else {
                StringBuilder foods = new StringBuilder();
                foods.append("You currently have the following food in your shopping list: " + "\n");
                return ((KitchenControlCentre) receiver).getShoppingList(((KitchenControlCentre) receiver).getUser()).toString();
            }
        } else {
            return "Ok, return to the main menu";
        }
    }

    @Override
    public void initiate(Scanner s) {
        System.out.println("Would you like to see your shopping list? Input 'YES' or 'NO'.");
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
