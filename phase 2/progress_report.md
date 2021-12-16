### Phase 2 Progress Report

###### Summary

Our project is a kitchen organizer that allows users to organize their food and recipes. It includes features such as stroring and sorting their recipes by category, creating shopping lists for food they need, adding un-owned food from a recipe to a shopping list, and tracking food expiration dates. The program contains 5 entity classes (Food (an abstract classO, Kitchen, Recipe, User, and UserList), 8 usecase classes (FoodManager, RecipeManager, FoodFactory, FoodSorter, RecipeSorter, ShoppingListManager, LoginManager, and userManager), an abstract ControlCentre class with 7 child classes (FoodControlCentre, KitchenControlCentre, LoginDController, LoginInputBoundary, RecipeControlCentre, UserControlCentre, and UserDetailsController), 31 Commonds that allow the user to request and input information, and 3 constants for recipe sorting (Constants, MealCountry, MealTime), and a UI class. Our program makes use of a vareity of design strategies, such as generics, and Design Patterns, such as the Factory Design Pattern, the Filter Design Pattern, and the Command Design Pattern.


###### Questions

- How can we access the specific control centres we need in each command?

- How can we implement the initiate/execute structure in commands with only one function?


###### What Has Worked Well With Our Design

- The way that we packed our classes by each layer of the program allowed us to maintain a clear path for communication to be passed along while maintaining Clean Architecture and provided us with a clear outline for how we should divide up the functions of the program.

- Our design has incorporated various Design Patterns that have been helpful in solving any problems that come up as we were developing. For example, the filter design pattern was helpful in providing a method to sort recipes by categories. In addition to be generally helpful in providing functional help, these Design Patterns solutions have also helped adhere to SOLID principles

- The choices we have made for our design (including the packaging methods and Design Patterns) has helped us maintain Clean Architecture, which was, at some points of our development, a challenge in certain portions of the program


###### What Each of Us Have Been Working On Since Phase1

Marco
- Adding additional testing for all Recipe related commands and functions
- Adding in more docstrings for previous work
- Implementing UI class
- Updating Recipe commands to include generics
- Updated Constants
- Accessibility.md
- specification.md
- Significant Pull Request: https://github.com/CSC207-UofT/course-project-csc207-team-ramsey/pull/79
- Signficant Pull Request: https://github.com/CSC207-UofT/course-project-csc207-team-ramsey/pull/30

Mer
- Adding testing for Food entity and managers
- Adding testing for food commands 
- Updating Food commands to include generics
- Adding in more docstrings for Food classes
- Added classes and commands for sorting food
- Refactoring packages 
- Added constants for food commands
- design_document.md
- specification.md
- Significant Pull Request: https://github.com/CSC207-UofT/course-project-csc207-team-ramsey/pull/80
- Significant Pull Request: https://github.com/CSC207-UofT/course-project-csc207-team-ramsey/pull/33/files

Tosha
- Adding testing for Kitchen related commands and functions
- Adding in more docstrings for previous work
- Updating Kitchen commands to include generics and obey clean architecture
- Adding tests for Kitchen Commands
- Add in Constants
- progress_report.md
- specification.md
- Significant Pull Request: https://github.com/CSC207-UofT/course-project-csc207-team-ramsey/pull/71
- This pull request adds significant updates to the commands needed to fulfill the kitchen responsibilities, which is a major component of the program

Sora
- Implementing User system
- Serializing User
- Updating User commands
- Adding in User testing
- specification.md
- Significant Pull Request: 
