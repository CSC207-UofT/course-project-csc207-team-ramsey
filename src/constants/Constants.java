package constants;
import commandline.*;

import java.util.Hashtable;

public class Constants {

    public static final Hashtable<String, CommandExecute> COMMANDS_DIC =
            new Hashtable<String, CommandExecute>();

    static {
        COMMANDS_DIC.put("crtuser", new CreateUserCmd());
        COMMANDS_DIC.put("crtfood", new CreateFoodCmd());
        COMMANDS_DIC.put("crtrecipe", new CreateRecipeCmd());
        COMMANDS_DIC.put("srtfood", new SortFoodCmd());
        COMMANDS_DIC.put("srtrecipes", new SortRecipeCmd());
    }
}
