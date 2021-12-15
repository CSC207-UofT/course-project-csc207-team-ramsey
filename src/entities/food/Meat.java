package entities.food;

/**
 * This class represents a meat, it is a child class for the class food.
 */
import java.io.Serializable;

public class Meat extends Food implements Serializable {

    public Meat(int sl, String name, int quantity, String unit) {
        super(sl, name, quantity, unit);
    }
}
