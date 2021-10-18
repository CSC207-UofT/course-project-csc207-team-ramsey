### **Scenario Walk-Through**

User opens the program for the first time and is prompted to create a username and
password. ControlCentre receives the commands and creates a User entity. 
Select an option from the main menu of what to do in the app (create food/recipe, 
show food/shopping list, add ingredients, make a recipe). Create a new food, adding 
in the name, quantity, shelf life, unit, and date of purchase. ControlCentre takes in 
the input and sends it to FoodManager to make a new food entity. The food is added to 
User's food list. Add as much food as desired. Return to menu and create a new recipe, 
adding input for the recipe title, serving size, prep time, ingredients, and steps. 
ControlCentre takes in the input and sends it to RecipeManager, which creates a new 
recipe and adds it to User's list of recipes. 

Return to main menu and select option to make a recipe. Input the desired ingredients to 
work with, ControlCentre will send the input and send it to RecipeManager, which will 
return a list of recipes (from the User's recipe list) containing the ingredients. Select a 
recipe to make. If the recipe contains ingredients that have not been added, the ingredients 
will be added to the User's shopping list through FoodManager. Otherwise, the user can select 
the number of servings they want to make and the quantities will be adjusted through Recipe. Select 
this recipe to make, the amount of ingredients used will be removed from the User's food through 
FoodManager.
