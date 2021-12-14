package entities.food;

import java.io.Serializable;

public class Dairy extends Food implements Serializable {
    public Dairy(int sl, String name, int quantity, String unit) {
        super(sl, name, quantity, unit);
    }
}
