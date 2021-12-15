package entities.food;

/**
 * This class represents a grain, it is a child class for the class food.
 */
public class Grains extends Food{
import java.io.Serializable;

public class Grains extends Food implements Serializable {
    public Grains(int sl, String name, int quantity, String unit) {
        super(sl, name, quantity, unit);
    }
}
