package driver;
import commandline.CreateFoodCmd;
import controllers.FoodControlCentre;
import entities.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        FoodControlCentre foodControlCentre = new FoodControlCentre();
        User user = new User("wmdad", "adaw", "asdaw");
        CreateFoodCmd food = new CreateFoodCmd(foodControlCentre, user);

        food.createFoodLineCall(s);
    }
}
