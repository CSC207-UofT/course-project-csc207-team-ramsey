package Entities.Food;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Meat extends Food{

    public Meat(int sl, String name, int quantity, String unit) {
        super(sl, name, quantity, unit);
    }
}
