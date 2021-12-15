package entities.food;

import java.io.Serializable;

public class Grains extends Food implements Serializable {
    public Grains(int sl, String name, int quantity, String unit) {
        super(sl, name, quantity, unit);
    }
}
