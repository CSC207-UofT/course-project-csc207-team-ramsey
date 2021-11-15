Summary

Our project allows people to store and sort their foods and recipes so that they can easily buy necessary ingredients, understand what recipes they can make, and helps track foods that may expire soon. We have 3 entity classes (User, Kitchen, and Food (an abstract class)), 7 use case classes (FoodManager, RecipeManager, FoodFactory, FoodSorter, RecipeSorter, ShoppingListManager, and userManager), 1 abstract ControlCentre class with 4 child classes (FoodControlCentre, KitchenControlCentre, RecipeControlCentre, and UserControlCentre), 18 Commonds that allow the user to request and input information, and 3 constants for recipe sorting (Constants, MealCountry, MealTime). Users should be able to use features such as creating and editing account details, adding new foods/recipes, see their foods/recipes, sorting their recipes and foods, creating and adding items to their shopping list, and adding/removing food from their kitchen based on the food they buy from their shopping list and the recipes they make. 

Questions
There are some instances where our controllers call on entities right now, is there a better way to fulfil these functions? 

How can we implement design patterns in the next responsibilities we need to add. 


What Has Worked Well in Our Group
Our group communication continues to work very well. We meet up multiple times per week to discuss what everyone has been up to, ask questions, and decide what needs to be 
done next. 

We have intentionally been addressing previous issues and questions from Phase0, such as issues with private vs public attributes, commandline setup, and design questions. 


What Has Worked Well With Our Design
Implemening design patterns has allowed our code to function in the way we envisioned without making it too messy and helping follow the SOLID design principles; it has helped keep everything organized and create a natural flow of responsibilities. 

Our design patterns have also allowed us to address previous issues we were having regarding the design of our program. For example, we were unsure how to address making instances of Food when there is so much variation between food categories and units and stuff, so we used the Factory Design Pattern to address this. 


What Each of Us Have Been Working On + What's Next

Everyone in our group worked on the specification and UML together. 

Marco - RecipeSorter, RecipeManager, Recipe Entity updates, RecipeControlCentre, Recipe Commands, Constants

Tosha - Kitchen Entity, Kitchen ControlCentre, ShoppingList Manager, Kitchen Commands, progress report

Mer - Food Entity updates, Food Manager, Food ControlCentre, Food Commands, design document

Martin - Food and Recipe Sorters (???)

Sora - UserEntity updates, UserManager, UserControlCentre, UserCommands

Since we all meet, our tasks tend to get a bit more entangled, but we all helped each other to complete as much as we can!

We still plan to adding functionality to our program. We still want to work on, sorting recipes and foods by certain categories, being able to change serving sizes so that users can change how much of something they want to make, and sorting foods by their expiration date. 

We will need to add in more commands that prompt the user to adjust serving sizes and make use of the expiration dates. We will also have to work on finding a solution to areas where SOLID principles have been violated. 
