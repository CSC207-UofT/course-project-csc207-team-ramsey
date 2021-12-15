package test;

import commandline.KitchenShoppingListCommands.DisplayKitchenFoodCmd;
import controllers.KitchenControlCentre;
import entities.food.Food;
import entities.User;
import org.junit.Before;
import org.junit.Test;
import usecases.FoodFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Class for testing the DisplayKitchenFood Command
 */

public class TestDisplayKitchenFoodCmd {
    KitchenControlCentre kitchenControl;
    User user;
    ArrayList<Food> food;
    DisplayKitchenFoodCmd<KitchenControlCentre> showDisplayKitchenFoodCmd;

    @Before
    public void setUp() {
        user = new User("Guy", "CoolUserGuy", "cooluseremail@aaaaaa.ca", "pass");
        ArrayList<Food> food = user.getKitchen().getFood();
        Food exFood = FoodFactory.getFood("meats", "Chicken", 7, 2, "grams");
        Food exFood2 = FoodFactory.getFood("dairy", "Milk", 10, 500, "ml");
        food.add(exFood);
        food.add(exFood2);

        showDisplayKitchenFoodCmd = new DisplayKitchenFoodCmd<KitchenControlCentre>(kitchenControl);
    }

    @Test(timeout = 50)
    public void TestDisplayRecipesInitiate() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("full\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        showDisplayKitchenFoodCmd.initiate(new Scanner(System.in));

        System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String[] lines = outputText.split("\\n");

        assertEquals(lines[lines.length-1].trim(), "- Chicken: 2 grams");
    }
}
