package driver;
import commandline.CreateFoodCmd;
import controllers.FoodControlCentre;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        FoodControlCentre foodControlCentre = new FoodControlCentre();
        CreateFoodCmd food = new CreateFoodCmd(foodControlCentre);

        food.createFoodLineCall(s);
    }
}
