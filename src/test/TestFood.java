package test;

import controllers.FoodControlCentre;
import entities.Kitchen;
import entities.User;
import entities.food.Food;
import entities.food.FruitVegi;
import org.junit.Before;
import org.junit.Test;
import usecases.RecipeManager;

import java.util.HashMap;

public class TestFood {
    Kitchen kitchen;
    FoodControlCentre foodControlCentre;
    @Before
    public void setUp() {
        Kitchen kitchen = new Kitchen();
    }

    @Test(timeout = 50)
    public void TestGetInfoQuantity() {
        User user = new User("ADA", "FSES", "ASDAW", "ADW");
        FoodControlCentre foodControlCentre = new FoodControlCentre(user);
        Food g = foodControlCentre.createEntity("FruitVegi", "Banana", 5, 10, "Whole");
        System.out.println(g.getInfoFood());

        g.addQuantity("5");
        g.addEntry("2022-11-14", "12");
        g.removeEntry("14-11-2021");

        System.out.println(g.getInfoQuantity());
        g.removeQuantity("12");

        System.out.println(g.getInfoQuantity());

    }
}
