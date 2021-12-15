package entities.food;

import java.io.Serializable;

/**
 * This class represents a soup or condiment, it is a child class for the class food.
 */
public class SoupsCond extends Food implements Serializable {
    public SoupsCond(int sl, String name, int quantity, String unit) {
        super(sl, name, quantity, unit);
    }
}
