package test.FoodTests;


import entities.food.Food;
import entities.food.FruitVegi;
import org.junit.Before;
import org.junit.Test;

import entities.*;
import usecases.*;

import java.util.Objects;


public class TestFood {
    FoodManager foodManager;
    User user;
    Food food;

    @Before
    public void setUp() {
        user = new User("ADA", "FSES", "ASDAW", "ADW");
        food = new FruitVegi(5, "Banana", 3, "whole");
    }

    @Test(timeout = 50)
    public void TestGetQuantity() {
        assert (food.getQuantity() == 3);

        food.addEntry("2020-11-30", "6");
        assert (food.getQuantity() == 9);

        food.addEntry("2020-12-30", "2");
        food.addEntry("2020-1-30", "8");
        assert (food.getQuantity() == 19);
    }
    @Test(timeout = 50)
    public void TestGetSetName() {
        assert (Objects.equals(food.getName(), "Banana"));

        food.setName("Apple");

        assert (Objects.equals(food.getName(), "Apple"));
    }

    @Test(timeout = 50)
    public void TestGetSetShelfLife() {
        assert (Objects.equals(food.getShelfLife(), 5));

        food.setShelfLife(7);

        assert (Objects.equals(food.getShelfLife(), 7));
    }

    @Test(timeout = 50)
    public void TestGetSetUnit() {
        assert (Objects.equals(food.getUnit(), "whole"));

        food.setUnit("grams");

        assert (Objects.equals(food.getUnit(), "grams"));
    }

    @Test(timeout = 50)
    public void TestAddQuantity() {
        food.addQuantity("8");

        assert (food.getQuantity() == 11);
        assert (food.getDates().size() == 2);
    }

    @Test(timeout = 50)
    public void TestRemoveEntry() {
        food.addEntry("2020-12-30", "2");
        food.addEntry("2020-1-30", "8");

        food.removeEntry("2020-1-30");
        assert (food.getDates().size() == 2);
    }
}
