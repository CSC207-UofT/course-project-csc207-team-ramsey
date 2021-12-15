package test.KitchenShoppingListTests;

import entities.User;
import org.junit.Before;
import org.junit.Test;
import usecases.ShoppingListManager;
import usecases.FoodFactory;
import entities.food.Food;


import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Class for testing the ShoppingListManager
 */

public class TestShoppingListManager {
    ShoppingListManager shoppingListManager;
    User user;
    Food exampleItem;

    @Before
    public void setUp() {
        user = new User("Guy", "CoolUserGuy", "cooluseremail@aaaaaa.ca", "pass");
        shoppingListManager = new ShoppingListManager();
        exampleItem = FoodFactory.getFood("FRUITVEGI", "apple", 1, 14, "whole");
    }

    @Test(timeout = 50)
    public void TestAddNewFood() {
        Food toAdd = FoodFactory.getFood("GRAINS", "rice", 365, 700, "grams");
        shoppingListManager.addFood(user, toAdd);
        ArrayList<Food> foodList = new ArrayList<Food>();
        foodList.add(toAdd);
        assertEquals(user.getKitchen().getShoppingList(), foodList);
    }

    @Test(timeout = 50)
    public void TestBuyAllFood() {
        ArrayList<Food> foodList = new ArrayList<Food>();
        Food milk = FoodFactory.getFood("DAIRY", "milk", 14, 250, "ml");
        Food beef = FoodFactory.getFood("MEAT", "beef", 7, 500, "grams");
        foodList.add(milk);
        foodList.add(beef);
        shoppingListManager.buyAllFood(user);
        assertEquals(user.getKitchen().getShoppingList(), foodList);
    }

    @Test(timeout = 50)
    public void TestDeleteItem() {
        ArrayList<Food> foodList = new ArrayList<Food>();
        Food milk = FoodFactory.getFood("DAIRY", "milk", 14, 250, "ml");
        Food beef = FoodFactory.getFood("MEAT", "beef", 7, 500, "grams");
        foodList.add(milk);
        foodList.add(beef);
        foodList.add(exampleItem);
        shoppingListManager.deleteItem(user, exampleItem);
        assert !foodList.contains(exampleItem);
    }

}
