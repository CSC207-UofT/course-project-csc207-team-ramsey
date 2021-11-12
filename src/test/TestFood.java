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
        FoodControlCentre foodControlCentre = new FoodControlCentre();
        Kitchen kitchen = new Kitchen();
    }

    @Test(timeout = 50)
    public void TestGetInfoQuantity() {
        FoodControlCentre foodControlCentre = new FoodControlCentre();
        Food g = foodControlCentre.createEntity("FruitVegi", "Banana", 5, 10, "Whole");
        System.out.println(g.getInfoQuantity());
        System.out.println(g.getInfoFood());

        g.addQuantity("5");
        System.out.println(g.getInfoQuantity());

    }
}
