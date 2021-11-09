package Entities.Food;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * Represents a Entities.Food.Food for our fridge
 */
public abstract class Food {
    /** assuming shelfLife is in days */
    private int shelfLife;
    private String foodName;
    private int quantity;
    private String unit;
    private HashMap<String, String[]> dates;

    public Food(int sl, String name, int quantity, String unit) {
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

    public int getQuantity(){
        int quantity = 0;
        for (String[] val : this.dates.values()) {
            quantity += Integer.parseInt(val[0]);
        }
        return quantity;
    }
    public String getInfo(){
        return "";
    }
    public String getName(){
        return this.foodName;
    }

    public int getShelfLife(){
        return this.shelfLife;
    }

    public String getUnit(){
        return this.unit;
    }

    public String setName(String name){
        this.foodName = name;
        return this.foodName;
    }
//    public String setQuantity(int num, int quantity){
//    }

    public int setShelfLife(int newShelfLife){
        this.shelfLife = newShelfLife;
        return this.shelfLife;
    }

    public String setUnit(String unit){
        this.unit = unit;
        return this.unit;
    }


}
