### Phase 2 - Design Document

###### Major Design Decisions

We decided to add more classes to our project. Initially we only had 1 Controller, 2 use cases, and 3 entities. 
Now we have an abstract food entity, that has 5 child classes, Dairy, FruitVegi, SoupsCond, Grains, and meat. For
our food entity, we have 3 interfaces, Whole, Solid, and Liquid, which help with certain foods with different units. We also
have an abstract ControlCentre that has 4 child classes, FoodControlCentre, RecipeControlCentre, UserControlCentre, and
KitchenControlCentre. There are also individual classes for each command in the command line interface. This follows the Command design 
pattern that will be explained more later. We chose to add more classes to adhere closer to the SOLID design principles. Since our use cases
had many functions to do, we split the use cases up so that they are only responsible for one entity. We split the food entities so that 
they would be easier to sort and categorize. We considered that some foods groups can have multiple units, so it would be a good way to 
implement interfaces into our foods. That way, the child classes that require additional functionality can implement the interfaces.

###### Clean Architecture

We try to make sure that our project follows clean architecture to the best of our abilities. Entity classes would only call 
other functions from other entities, whereas the use cases would call the functions from the entities and other use cases. Our controllers *mostly*
only call functions from use cases and our command classes only call functions from the controllers. For instance, if a client wanted to display a 
certain food, they would type "show food" into the command line interface. This would prompt the class ShowFood.java to ask the user for the name of the
food they want to be displayed. In the execute function of the ShowFood class, it calls the function from FoodControlCentre, which calls the function from 
the use case FoodManager. FoodManager takes a food object and displays the details as a string. There are unfortuantely cases where the control class directly 
calls the functions from the entity class. This instance occurs between the Food entity and the FoodControlCentre for the removeQuantity function. This is because if the function were in the 
use cases the hashtable used to store the values would have to be replaced each time, which we thought was very memory 
intensive. So we are currently trying to find a way around that, so that our entity class only includes getters and setters.

###### SOLID design principles

SOLID design principles was something we didn't consider as much for Phase 0, but tried to pay more attention to during Phase 1.

###### Packaging strategies

###### Design patterns

