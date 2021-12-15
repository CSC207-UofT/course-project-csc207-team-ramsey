package entities.food;

import java.io.Serializable;

public class Meat extends Food implements Serializable {

    public Meat(int sl, String name, int quantity, String unit) {
        super(sl, name, quantity, unit);
    }
}
