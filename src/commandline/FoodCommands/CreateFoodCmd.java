package commandline.FoodCommands;

import commandline.Command;
import commandline.CommandExecute;
import controllers.FoodControlCentre;
import entities.food.Food;
import usecases.FoodFactory;

import java.util.ArrayList;
import java.util.List;

import java.util.Objects;
import java.util.Scanner;

/**
 * This class creates a new food
 * @param <T> the receiver
 */

public class CreateFoodCmd<T> extends Command<T> implements CommandExecute, FoodFactory {


    /**
     * The constructor for this class
     * @param receiver food control centre
     */
    public CreateFoodCmd(T receiver) {
        super(5, 5, receiver);
    }

    /**
     * Gets the arguments from initiate to give to the food controller
     * @param arguments the user inputs
     * @return a string for initiate to give back to the user
     */
    @Override
    public String execute(List<String> arguments){
        FoodControlCentre control = (FoodControlCentre) this.receiver;
        try {
            int sl = Integer.parseInt(arguments.get(2));
            int quantity = Integer.parseInt(arguments.get(3));

            try {
                Food newFood = control.createEntity(arguments.get(0), arguments.get(1), sl, quantity, arguments.get(4));
                if (newFood == null){
                    return "Your input is invalid";
                }
                control.addFoodToList(newFood, control.getUser().getKitchen());
                return "Your food has successfully been created";
            } catch (Exception e) {
                return "Your input is invalid";
            }
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            return "Your input is invalid";
        }
    }

    /**
     * a function that shows the users and gets inputs from the user
     * @param s the scanner that reads inputs
     */
    public void initiate(Scanner s){
        do {
            System.out.println("What type of food is your food (grains, meats, fruitvegi, dairy)?: ");
            String foodType = s.nextLine();

            System.out.println("What is the name of your food?: ");
            String foodName = s.nextLine();

            System.out.println("What is the shelf life of your food?: ");
            String sl = s.nextLine();

            System.out.println("What is the unit (whole, ml, grams?: ");
            String unit = s.nextLine();

            System.out.println("What is the quantity? ");
            String quantity = s.nextLine();
            

            ArrayList<String> arguments = new ArrayList<String>();
            arguments.add(foodType);
            arguments.add(foodName);
            arguments.add(sl);
            arguments.add(quantity);
            arguments.add(unit);

            String response = execute(arguments);
            System.out.println(response);

            if (Objects.equals(response, "Your input is invalid")) {
                System.out.println("Would you like to try again(y/n)");
            } else {
                System.out.println("Would you like to add another food(y/n)");
            }

        } while (!Objects.equals(s.nextLine(), "n"));
    }

}
