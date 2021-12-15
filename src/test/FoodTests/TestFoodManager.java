package test.FoodTests;

import controllers.FoodControlCentre;
import entities.Kitchen;
import entities.User;
import entities.food.Food;
import org.junit.Before;
import org.junit.Test;
import usecases.FoodManager;

public class TestFoodManager {
    FoodManager foodManager;
    Kitchen kitchen;
    @Before
    public void setUp() {
        kitchen = new Kitchen();
        foodManager = new FoodManager();
    }

    @Test(timeout = 50)
    public void TestGetInfoQuantity() {
        User user = new User("ADA", "FSES", "ASDAW", "ADW");
        FoodControlCentre foodControlCentre = new FoodControlCentre(user);
        Food g = foodControlCentre.createEntity("FruitVegi", "Banana", 5, 10, "Whole");
        System.out.println(foodManager.getInfoFood(g));

        g.addQuantity("5");
        g.addEntry("2022-11-14", "12");
        g.removeEntry("14-11-2021");

        System.out.println(foodManager.getInfoQuantity(g));
        foodManager.removeQuantity(g, "12");

        System.out.println(foodManager.getInfoQuantity(g));

    }
}
