import java.util.Objects;

public class ControlCenter {

    public static void createUser()
    {
        // Using Console to input data from user
        String name = System.console().readLine("What is your name? ");
        String username = System.console().readLine("What is your username? ");
        String email = System.console().readLine("What is your email? ");
        String password = System.console().readLine("What is your password? ");

        String newLine = System.getProperty("line.separator");
        System.out.println("Name: " + name + newLine + "Username: " + username +
                "Email: " + email + newLine + "Password" + password);
        String confirm = System.console().readLine("Is this correct? (Y/N)");

        if (Objects.equals(confirm, "Y") || Objects.equals(confirm, "y")) {
        //TODO: create user
        }
    }

    public static void createFood()
    {
        // Using Console to input data from user
        String foodname = System.console().readLine("What food was bought? ");
        String shelflife = System.console().readLine("What is the shelflife of " + foodname + " ? ");
        String unit = System.console().readLine("What is the unit/ how are you measuring " + foodname + " ? ");
        String calories = System.console().readLine("How many calories are in 1 unit (" + unit + ") of " + foodname + " ? ");

        String newLine = System.getProperty("line.separator");
        String isConfirmed = System.console().readLine("Is this correct?" + newLine + "Food: " + foodname + newLine + "shelf life: " + shelflife +
                "unit: " + unit + newLine + "calories/ unit" + calories);

    }

    public static void createRecipe()
    {
        // Using Console to input data from user
        String recipename = System.console().readLine("What is the name of the recipe? ");
        String servings = System.console().readLine("How many servings? ");
    }

    public static void updateFood()
    {
        //for updating foods
    }
    public static void updateUser()
    {
        //for updating users
    }
    public static void updateRecipe()
    {
        //for updating recipe
    }

    public static void main(String[] args)
    {
        ControlCenter controller = new ControlCenter();
        controller.createUser();

//      System.out.println("Hello " + )
    }
}