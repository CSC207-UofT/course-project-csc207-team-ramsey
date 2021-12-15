# Phase 2 - Design Document

### UML Diagram

https://lucid.app/lucidchart/0d1ddbfb-ae9b-4d1e-828f-1430f31d79cf/edit?viewport_loc=-5508%2C-3814%2C13750%2C6379%2CHWEp-vi-RSFO&invitationId=inv_9deaeeae-f89a-4712-ae82-0f4b53070412

### Design Patterns

#### Factory Pattern

We used the factory pattern in order to instantiate the foods in our program.


#### Command Pattern

The command pattern was used for our command line interface.

#### Filter Pattern

We used the filter pattern to make a sorter for our user's recipe list.

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

###### SOLID and Design Patterns

SOLID
Our design was made to closely adhere to the Single Responsibility Principle and Open Closed Principle, and the design 
patterns we used should reflect this design choice.

Firstly, we used to factory method to move our food creation into one place within the program, which makes the code 
easier to support. With this pattern, we can easily introduce new types of foods into the program without breaking our 
code (OCP). The disadvantage of this pattern, though, is that it can make our code drastically more complicated, since 
we needed to introduce many new subclasses for our Entity.

Secondly, we used the command design pattern in order to encapsulate our command line interface. We used this pattern 
because we wanted to implement reversible operations with easy extensibility. Since we have a separate Command class 
for each of of our user actions, we adhere to SRP; furthermore, the OCP is followed since we can easily introduce new 
commands to our application.

Thirdly, we used the filter command in order to easily allow our user to sort their list of recipes.  We used this 
design pattern since we believed it would be useful to create individual classes to filter our recipe list depending 
on each recipe category we have listed (following SRP). Also, since we can simply implement a new filter class whenever
we want to add a new recipe category we are also closely following OCP. In addition, we've integrated the pattern with
enums in order to easily keep track of the new categories we include for recipes.

###### Packaging strategies

We packaged everything by layer. We have a package for entities, one for usecases, which includes an interface used for the factory method, one for controllers, and one for the 
commandline. This commandline is a package for the classes involved in the UI and the controllers. They directly communicate with the command line (except Command and CommandExecute, but they are there
because all the commands extends Command and implement CommandExecute). These classes also call functions from the use cases, where the package driver is only for communicating with the UI.
We decided to organize it this way because many of the classes in the layer are similar and extend a parent class. This allows us as developers to keep 
track of Clean Architecture and easily identify the segregation of our program layers. However, we've also come to realize
that this can separate a lot of components for an individual feature. For example, when we implement a new feature, we
have to make new classes in multiple different files.



