import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * Represents a Food for our fridge
 */
public class Food {
    /** assuming shelfLife is in days */
    private int shelfLife;
    private String foodName;
    private int calories;
    private String foodUnit;
    private int quantity;
    private HashMap<LocalDateTime, String[]> dates;

    /**
     * Creates an instance of Food
     * @param sl the shelf life of the food
     * @param name food name
     * @param cals the calorie content per food serving
     * @param unit the unit of measurement for the food
     */
    public Food(int sl, String name, int cals, String unit) {
        this.shelfLife = sl;
        this.foodName = name;
        this.calories = cals;
        this.foodUnit = unit;

        LocalDateTime buyDate = LocalDateTime.now();
        LocalDateTime expDate = buyDate.plusDays(shelfLife);
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedBuy = buyDate.format(formatObj);
        String formattedExp = expDate.format(formatObj);

        String[] quantExp = {Integer.toString(quantity), formattedExp};
        this.dates = new HashMap<LocalDateTime, String[]>();
        dates.put(buyDate, quantExp);

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
