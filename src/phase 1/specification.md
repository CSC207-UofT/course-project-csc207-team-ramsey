### **Project Specifications**
The app allows users to have a practical meal planning experience with a straightforward and functional design. It allows users to add in their recipes, check their pantry, shopping list and will keep track of expiring items to alert the user before the date.

Food - Users can start by adding all the ingredients/ foods that they have in their home, with each food item containing its name, quantity, shelf life, and expiration date. Users should be able see their foods based on certain criteria ie. expiration.

Recipe - Users may also add their own recipes where they can use the recipe function to search for recipes based on specific preferences, such as key ingredient, availability of ingredients, or based on the expiration date of items in the user’s pantry.

Shopping List - If required items are not available, then item will be added to a shopping list for the user.

### New functionality

We've added a User login, registration, and serialization using the Jackson Library. We've also added a few new commands to allow the user to

see the full list of recipes and food as wells as view recipes of a specific category which we've tagged in an enum.

**Login/Registration UI**

'login' = login a user

'sign up' - register a user

**Commands**

`addNewFood ` - adds a new food, requires food name, quantity, shelf life and unit, (doesn't work if food already exists)

'deleteFood' - deletes a food from users food list

'displayFoodList' - displays user's list of food

`displayFood` - displays all foods and quantities

`addRecipe` - adds a new recipe (requires new, servings, time, instructions, and ingredients:quantities)

'deleteRecipe' - deletes a recipe from user's list

`displayRecipe` - displays a recipe's details

'displayRecipeList' - displays user's list of recipes

'displayShoppingList' = displays user's Shopping List

'addToShoppingList' - adds a food to the Shopping List

`quit` - quits program