package test;


import org.junit.Before;
import org.junit.Test;

import Entities.*;
import use_cases.*;

import static org.junit.Assert.assertEquals;


public class TestFoodManager {
    FoodManager foodManager;
    User user;

    @Before
    public void setUp() {
        user = new User("Bob", "Bob", "bob@user.ca");
        foodManager = new FoodManager();
    }

    @Test(timeout = 50)
    public void TestMakeNewFoodInUser() {
        foodManager.makeNewFood(user, "banana",5, 12);
        assertEquals(user.getFood().get(0).getName(), "banana");
    }

}
