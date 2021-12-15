package test;

import commandline.KitchenShoppingListCommands.DisplayShoppingListCmd;
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
 * Class for testing the ShowShoppingList Command
 */

public class TestDisplayShoppingListCmd {
    KitchenControlCentre kitchenControl;
    User user;
    ArrayList<Food> shoppingList;
    DisplayShoppingListCmd<KitchenControlCentre> showDisplayShoppingListCmd;

    @Before
    public void setUp() {
        user = new User("Guy", "CoolUserGuy", "cooluseremail@aaaaaa.ca", "pass");
        ArrayList<Food> shoppingList = user.getKitchen().getShoppingList();
        Food exFood = FoodFactory.getFood("meats", "Chicken", 7, 2, "grams");
        Food exFood2 = FoodFactory.getFood("dairy", "Milk", 10, 500, "ml");
        shoppingList.add(exFood);
        shoppingList.add(exFood2);

        showDisplayShoppingListCmd = new DisplayShoppingListCmd<KitchenControlCentre>(kitchenControl);
    }

    @Test(timeout = 50)
    public void TestDisplayRecipesInitiate() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("full\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        DisplayShoppingListCmd.initiate(new Scanner(System.in));

        System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String[] lines = outputText.split("\\n");

        assertEquals(lines[lines.length-1].trim(), "Chicken: 2 grams");
    }
}