package entities.food;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

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
        this.unit = unit;

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
    public StringBuilder getInfoQuantity(){
        StringBuilder returnString = new StringBuilder();
        for (Map.Entry<String, String[]> entry : this.dates.entrySet()){
            returnString.append("Bought Date: ").append(entry.getKey()).append("\n").append("Expiration Date: ").append(entry.getValue()[1]).append("quantity: ").append(entry.getValue()[0]).append("\n");
        }
        return returnString;
    }

    public StringBuilder getInfoFood(){
        StringBuilder returnString = new StringBuilder();
        returnString.append("Food Name: ").append(this.foodName).append("\n").append("Shelf Life: ").append(this.shelfLife).append("\n").append("Quantity: ").append(this.getQuantity()).append("\n").append("Unit: ").append(this.unit);

        return returnString;
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
    public StringBuilder setQuantity(String dateAdded, String quantity){
        String[] modify = this.dates.get(dateAdded);
        modify[0] = quantity;
        this.dates.replace(dateAdded, modify);
        return this.getInfoQuantity();
    }

    public int setShelfLife(int newShelfLife){
        this.shelfLife = newShelfLife;
        return this.shelfLife;
    }

    public String setUnit(String unit){
        this.unit = unit;
        return this.unit;
    }

    public StringBuilder addQuantity(String quantity){
        LocalDateTime buyDate = LocalDateTime.now();
        LocalDateTime expDate = buyDate.plusDays(shelfLife);
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedBuy = buyDate.format(formatObj);
        String formattedExp = expDate.format(formatObj);

        String[] quantExp = {quantity, formattedExp};
        this.dates.put(formattedBuy, quantExp);

        return this.getInfoQuantity();
    }

    public StringBuilder removeEntry(String dateAdded, String quantity){
        this.dates.remove(dateAdded);
        return this.getInfoQuantity();
    }

    public StringBuilder removeQuantity(String dateAdded, String quantity){
        this.dates.remove(dateAdded);
        return this.getInfoQuantity();
    }

}
