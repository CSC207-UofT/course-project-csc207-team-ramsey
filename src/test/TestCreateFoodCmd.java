package test;

import commandline.CreateFoodCmd;

import controllers.FoodControlCentre;
import entities.User;
import org.junit.Before;
import org.junit.Test;
import usecases.FoodManager;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestCreateFoodCmd {
    FoodControlCentre foodControlCentre;
    FoodManager foodManager;
    User user;
    CreateFoodCmd createFoodCmd;

    @Before
    public void setUp() {
        user = new User("Bob", "Bob", "bob@user.ca", "1234");
        foodControlCentre = new FoodControlCentre(user);
        foodManager = new FoodManager();
        foodControlCentre.createEntity("GRAINS","rice", 30, 10, "grams");

        createFoodCmd = new CreateFoodCmd(foodControlCentre);
    }

    @Test(timeout = 50)
    public void TestCreateFoodInitiate() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("Grains\nrice\n30\n15\n10\ngrams\n".getBytes()));

        createFoodCmd.initiate(new Scanner(System.in));

        System.setIn(stdin);

        //assertEquals(user.getKitchen().getRecipes().get(1).getTitle(), "Lasagne");
    }

}

