package entities.food;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Represents a Entities.Food.Food for our fridge
 */

public abstract class Food implements Serializable {
    /** assuming shelfLife is in days */
    private int shelfLife;
    private String foodName;
    private int quantity;
    private String unit;
    private Hashtable<String, String[]> dates;

    public Food(int sl, String name, int quantity, String unit) {
        this.shelfLife = sl;
        this.foodName = name;
        this.unit = unit;

        LocalDate buyDate = LocalDate.now();
        LocalDate expDate = buyDate.plusDays(shelfLife);
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedBuy = buyDate.format(formatObj);
        String formattedExp = expDate.format(formatObj);

        String[] quantExp = {Integer.toString(quantity), formattedExp};
        this.dates = new Hashtable<String, String[]>();
        this.dates.put(formattedBuy, quantExp);

    }

    /**
     *
     * @return
     */
    public int getQuantity(){
        int quantity = 0;
        for (String[] val : this.dates.values()) {
            quantity += Integer.parseInt(val[0]);
        }
        return quantity;
    }
//    public StringBuilder getInfoQuantity(){
//        StringBuilder returnString = new StringBuilder();
//        int count = 1;
//        for (Map.Entry<String, String[]> entry : this.dates.entrySet()){
//            returnString.append(count).append(" - Bought Date: ").append(entry.getKey()).append(", Expiration Date: ").append(entry.getValue()[1]).append(", Quantity: ").append(entry.getValue()[0]).append("\n");
//            count ++;
//        }
//        return returnString;
//    }
//
//    public StringBuilder getInfoFood(){
//        StringBuilder returnString = new StringBuilder();
//        returnString.append("Food Name: ").append(this.foodName).append("\n").append("Shelf Life: ").append(this.shelfLife).append("\n").append("Quantity: ").append(this.getQuantity()).append("\n").append("Unit: ").append(this.unit);
//
//        return returnString;
//    }

    public String getName(){
        return this.foodName;
    }

    public int getShelfLife(){
        return this.shelfLife;
    }

    public String getUnit(){
        return this.unit;
    }

    public Hashtable<String, String[]> getDates(){return this.dates;}

    public String setName(String name){
        this.foodName = name;
        return this.foodName;
    }
    public void setQuantity(String dateAdded, String quantity){
        String[] modify = this.dates.get(dateAdded);
        modify[0] = quantity;
        this.dates.replace(dateAdded, modify);
    }

    public int setShelfLife(int newShelfLife){
        this.shelfLife = newShelfLife;
        return this.shelfLife;
    }

    public String setUnit(String unit){
        this.unit = unit;
        return this.unit;
    }

    public void addQuantity(String quantity){
        LocalDate buyDate = LocalDate.now();
        LocalDate expDate = buyDate.plusDays(shelfLife);
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedBuy = buyDate.format(formatObj);
        String formattedExp = expDate.format(formatObj);

        String[] quantExp = {quantity, formattedExp};
        this.dates.put(formattedBuy, quantExp);

    }

    public void removeEntry(String dateAdded){
        this.dates.remove(dateAdded);
    }

    public void addEntry(String dateAdded, String quantity){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate buyDate = LocalDate.parse(dateAdded, formatter);
        LocalDate expDate = buyDate.plusDays(shelfLife);
        String formattedExp = expDate.format(formatter);

        String[] quantityexpr = {quantity, formattedExp};

        this.dates.put(dateAdded, quantityexpr);
    }

//    public StringBuilder removeQuantity(String quantity){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        ArrayList<LocalDate> data = new ArrayList<>();
//        for (Map.Entry<String, String[]> entry : this.dates.entrySet()){
//            LocalDate dateTime = LocalDate.parse(entry.getKey(), formatter);
//            data.add(dateTime);
//        }
//        Collections.sort(data);
//        int quantityFormatted = Integer.parseInt(quantity);
//
//        for (LocalDate buyDate : data) {
//            String keyVal = buyDate.format(formatter);
//            int entryQuantity = Integer.parseInt(this.dates.get(keyVal)[0]);
//            if (entryQuantity > quantityFormatted){
//                this.dates.get(keyVal)[0] = Integer.toString(entryQuantity - quantityFormatted);
//                return this.getInfoQuantity();
//            } else if (entryQuantity == quantityFormatted){
//                this.removeEntry(keyVal);
//                return this.getInfoQuantity();
//            } else {
//                quantityFormatted = quantityFormatted - entryQuantity;
//                this.removeEntry(keyVal);
//            }
//
//        }
//        return this.getInfoQuantity();
//    }


}

