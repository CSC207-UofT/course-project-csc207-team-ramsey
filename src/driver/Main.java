package driver;
import commandline.CreateFoodCmd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        CreateFoodCmd food = new CreateFoodCmd();

        food.createFoodLineCall(s);
    }
}
