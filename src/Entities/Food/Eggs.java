package Entities.Food;

public class Eggs extends Meat{
    /**
     * Creates an instance of Entities.Food.Food
     *
     * @param sl       the shelf life of the food
     * @param name     food name
     * @param quantity
     * @param unit
     */
    public Eggs(int sl, String name, int quantity, String unit) {
        super(sl, name, quantity, unit);
    }
}
