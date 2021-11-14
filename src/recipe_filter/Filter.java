package recipe_filter;

import entities.Recipe;

import java.util.List;

public interface Filter {

    List<Recipe> apply(List<Recipe> recipes);
}
