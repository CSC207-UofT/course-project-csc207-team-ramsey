package entities.food;

import java.io.Serializable;

public class FruitVegi extends Food implements Serializable {
    public FruitVegi(int sl, String name, int quantity, String unit) {
        super(sl, name, quantity, unit);
    }
}
