package Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents a Entities.Food for our fridge
 */
public class Food {
    /** assuming shelfLife is in days */
    private int shelfLife;
    private String foodName;
    private int quantity;
    private HashMap<String, String[]> dates;

    /**
     * Creates an instance of Entities.Food
     * @param sl the shelf life of the food
     * @param name food name
     */
    public Food(int sl, String name, int quantity) {
        this.shelfLife = sl;
        this.foodName = name;

        LocalDateTime buyDate = LocalDateTime.now();
        LocalDateTime expDate = buyDate.plusDays(shelfLife);
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedBuy = buyDate.format(formatObj);
        String formattedExp = expDate.format(formatObj);

        String[] quantExp = {Integer.toString(quantity), formattedExp};
        this.dates = new HashMap<String, String[]>();
        dates.put(formattedBuy, quantExp);

    }

    public int getQuanity(){
        int quantity = 0;
        for (String[] val : this.dates.values()) {
            quantity += Integer.parseInt(val[0]);
        }
        return quantity;
    }

    public String getName(){
        return this.foodName;
    }

}
