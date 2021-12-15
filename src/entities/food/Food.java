package entities.food;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


/**
 * This class represents an abstract class food, where the shelf life, quantity, unit, name, and expiration dates are saved
 */
public abstract class Food {

    private int shelfLife;
    private String foodName;
    private String unit;
    private final Hashtable<String, String[]> dates;

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
     * @return the total quantity of the number of units as an integer
     *
     * This function parses through this.dates to get the total quantity of a food
     */
    public int getQuantity(){
        int quantity = 0;
        for (String[] val : this.dates.values()) {
            quantity += Integer.parseInt(val[0]);
        }
        return quantity;
    }

    /**
     *
     * @return the name of the food as a string
     */

    public String getName(){
        return this.foodName;
    }

    /**
     *
     * @return the shelf life of food as an integer (in days)
     */
    public int getShelfLife(){
        return this.shelfLife;
    }

    /**
     *
     * @return the unit of the food as a string
     */
    public String getUnit(){
        return this.unit;
    }

    /**
     *
     * @return the dates as bought date: [quantity, expiration date] as a hastable
     */
    public Hashtable<String, String[]> getDates(){return this.dates;}

    /**
     *
     * @param name the new name of food that will be changed
     *
     * This function replaces the name of food with the new name, name
     */
    public void setName(String name){
        this.foodName = name;
    }

    /**
     *
     * @param dateAdded represents the date that the food was added, used to find the exact entry
     * @param quantity represents the value that needs to be changed in the entry
     *
     * This function finds an entry in this.dates that matches dateAdded and replaces the quantity with the new quantity
     */
    public void setQuantity(String dateAdded, String quantity){
        String[] modify = this.dates.get(dateAdded);
        modify[0] = quantity;
        this.dates.replace(dateAdded, modify);
    }

    /**
     *
     * @param newShelfLife the new value of shelf life in days (integer)
     */
    public void setShelfLife(int newShelfLife){
        this.shelfLife = newShelfLife;
    }

    /**
     *
     * @param unit new unit to replace the unit used before
     */
    public void setUnit(String unit){
        this.unit = unit;
    }

    /**
     *
     * @param quantity the amount to be added as a new entry
     *
     * This function creates a new entry in this.dates using the time the entry was made and the shelf life to create the expiration
     */
    public void addQuantity(String quantity){
        LocalDate buyDate = LocalDate.now();
        LocalDate expDate = buyDate.plusDays(shelfLife);
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedBuy = buyDate.format(formatObj);
        String formattedExp = expDate.format(formatObj);

        String[] quantExp = {quantity, formattedExp};
        this.dates.put(formattedBuy, quantExp);

    }

    /**
     *
     * @param dateAdded the date of the entry that should be deleted from this.dates
     */
    public void removeEntry(String dateAdded){
        this.dates.remove(dateAdded);
    }

    /**
     *  this function is used for testing purposes
     *
     * @param dateAdded the date of the entry that should be deleted from this.dates
     * @param quantity the amount added
     */
    public void addEntry(String dateAdded, String quantity){
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formattedBuy = LocalDate.parse(dateAdded, formatObj);
        LocalDate expDate = formattedBuy.plusDays(shelfLife);
        String formattedExp = expDate.format(formatObj);

        String[] quantExp = {quantity, formattedExp};
        this.dates.put(dateAdded, quantExp);

    }

    /**
     * Helper function to get the earliest dates
     * @return the first date in this.dates
     */
    public LocalDate getEarliestDate (){
        ArrayList<LocalDate> boughtDates = new ArrayList<>();
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (String dates: this.dates.keySet()){
            LocalDate formattedBuy = LocalDate.parse(dates, formatObj);
            boughtDates.add(formattedBuy);
        }
        Collections.sort(boughtDates);

        return boughtDates.get(0);
    }
}
