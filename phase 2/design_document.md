# Phase 2 - Design Document

### UML Diagram

https://lucid.app/lucidchart/0d1ddbfb-ae9b-4d1e-828f-1430f31d79cf/edit?viewport_loc=-5508%2C-3814%2C13750%2C6379%2CHWEp-vi-RSFO&invitationId=inv_9deaeeae-f89a-4712-ae82-0f4b53070412

### Major Design Decisions

- We decided to add generics to the commands. 
  - Since each command requires a receiver and each receiver is different depending on the command, we didn't want to use too much casting because of the different types. 
  - Originally, we were trying to use an abstract class for the receiver, however the control centres were very different from each other, and it wasn't working the way we had hoped
    - Since the control centres were so different, they all required different functions so the abstract class ControlCentre was more of a nuisance than a helpful tool.
  - Generics was a way to pass all the control centres into the commands without needing them to have an abstract class
  - We were also hoping that it will solve the problem of using casting however, we weren't able to find a way around it without having to create a new control centre instance in each command
  

- We added a UI class 
  - This was a way to encapsulate all our commands without having to use our main function and to avoid cluttering. 
  - This way we could have a place where all our constants can be used and provided a cleaner work experience.


- We decided to add food sorters to our program.
  - We wanted to do food sorters originally, but it never really git in the way we wanted it to. However, during this phase we were able to find time to implement it and have it be useful for the users.
  - Adding a way to sort the food was more of an accessibility to user, especially if they have lots of foods
  - We also thought that it would tie in well with the overall goal of our project, which was to create an easy way to create and make food.
  - Especially since this is aimed at a demographic who may find it difficult to keep track of what they have, a way to sort the food should be a given.
  - Also, since food was an abstract class, the child classes should be put to use in this way.


- Adding recipe sorters
  - We used the filter design pattern to create the recipe sorter
  - Recipe sorting was different from food sorting since there aren't any child classes so we used enums instead. 


- Got rid of interfaces for food. 
  - Originally, the child classes were used to be able to convert units depending on the type of food. For instance, fruits and vegetables would inherit functions from solid, liquid and whole interfaces, but we were never able to find a use for these methods as of now.
  - We think that these methods may be useful in the future, but as of now, they don't provide much relevance to the whole of the program.

### Clean Architecture

Clean architecture was definitely as aspect we tried to maintain as we kept adding features to our program. Last time there were issues where classes from
our controllers would call directed on methods from the entity. However, those were fixed. For example, 
in food there was a method that would remove a quantity from the hashtable of quantities. 
The reason it was there was because it required a large change to the entire hashtable, and changing it in food manager to replace the whole
hashtable was not a path we wanted to go down. So instead, many helper functions were created to be able to edit
the hashtable values, keys and entries and the method was moved to the food manager class. 

Currently, all our commands will take in arguments from the user which will be passed to the respected receiver. 
The receiver will take that information and modify it so that the managers are able to read the data. The managers will 
modify the entities and then return it back for the user to see. Every part works very similar to each other, and no part 
called on an aspect they shouldn't be calling on. 

So, while the interfaces and outward design patterns may change, our core business rules are a solid foundation to follow 
as the program may adapt and grow in the future. Speaking of SOLID.....

### SOLID
Our design was made with clean architecture in mind, but with every major design decision we made, 
we also tried to adhere as close to SOLID principle as we could.

- Single Responsibility
  - All of our classes only hold one responsibility. 
  - For instance, there's one use case responsible for creating food entities, one for changing and modifying food entities, and one for sorting and organizing food entities.
  - The different types of use cases make it easier to test and figure out whether there is a bug and where the problem lies
  - Typically, for the use cases it only depends on the food entity themselves and tries not too hard to rely on each other for them to work therefore allows for lower coupling and will not cause further problems in the design
  - Helps with the organization of the code and packaging styles
  

- Open for Extension Closed for Modification
  - All the entity classes showcase this principle really well since all of them are able to be extended but only can be modified using use cases
  - Our command design pattern also allows so that each command class cannot be modified but can be extended off of each other
  - Using the command pattern we were able to showcase this principle well


- Liskov Substitution
  - Especially showcased in our Food classes we can substitute any subclass or child class of Food with another subclass without disrupting any behaviour of the program


- Interface Segregation
  - Since we have many large interfaces and many large commands, we separated all of our commands in different files so that it creates a cleaner main function
  - We also created a UI.java class to store the constants and for users to be able to use our commands without having to clutter them in the main function


- Dependency Inversion
  - This was the most difficult principle for us to follow. Many of our entities are dependent on each other, making them difficult to test. 
  - However or use cases and controllers follow this principle well where there are interfaces to help prevent dependence on each other.
  


### Packaging strategies

As we mentioned from before, we decided to package everything by layer and we decided to stick with this packaging strategy.
So to reiterate, we have a package for entities, one for usecases, which includes an interface used for the factory method, one for controllers, and one for the 
commandline. However, we decided to make some changes to the packaging methods when it came to the commandline. So the commandline classes are still packaged together, however we decided to group by feature inside the commandline package. This commandline is a package for the classes involved in the UI and the controllers. They directly communicate with the command line (except Command and CommandExecute, but they are there
because all the commands extends Command and implement CommandExecute). These classes also call functions from the use cases, where the package driver is only for communicating with the UI. We found that
as our program grew, so did the number of commands we have. It got to a point where the package was so messy and hard to access we decided that needed to change. After deliberating on how we should organize it, 
we decided on packaging them by their features. So food commands will go together, recipe commands will go together etc. 
We decided that this was the best way to organize it because it allowed us to see which commands each feature had and which ones could potentially be missing. It also helped
when it came to grouping the commands in constants together. 

Our uses cases and controller packages stayed the same because many of the classes in the layer are similar even though some may no longer extend their original parent class. 
Both our new and old packaging strategies allows us as developers to keep 
track of Clean Architecture and easily identify the segregation of our program layers.

Another change was to our phases. We made sure to keep them outside the src

Lastly we also made a change to our test cases. Since most of the test.java files were made to test the commands
we thought that it should be organized in a similar way to the commands to keep things consistent and clean.
It also helps to see which commands or files still ned additional testing.

### Design Patterns

#### Factory Pattern
The Factory Method Pattern is a creation pattern that uses an interface to deal with the problem of creating objects 
without having to specify the exact class of the object that will be created. This pattern works well when creating 
many child classes of a certain abstract class that users themselves have to create.
For our food entity we have a food factory interface that takes in a type of food which is a string
and creates a child class of the certain food depending on the type. We used this pattern because there are five child
classes of food and so instead of creating five different constructors the food factory design pattern requires only the
food factory interface to create the required type of food. 
We used the factory method to move our food creation into one place within the program, which makes the code
easier to support. With this pattern, we can easily introduce new types of foods into the program without breaking our
code (OCP). The disadvantage of this pattern, though, is that it can make our code drastically more complicated, since
we needed to introduce many new subclasses for our Entity.
We used the factory pattern in order to instantiate the foods in our program.


#### Command Pattern

The command design pattern is a behavioural design patter in which an object is used to encapsulate all information needed
to perform an action or trigger an event. This works very well for our program because we have more than ten different commands 
that a user can call at any time. This design pattern is used on all of our commands and the receiver is our control centres
for the respected commands. For instance, the receiver for the showFood command would be foodControlCentre which passes the
information to the use case foodManager. We used the command design pattern in order to encapsulate our command line interface. We used this pattern
because we wanted to implement reversible operations with easy extensibility. Since we have a separate Command class
for each of our user actions, we adhere to SRP; furthermore, the OCP is followed since we can easily introduce new
commands to our application.

#### Filter Pattern
The filter design pattern is a design pattern that allows us to filter a set of objects using different criteria and chaining them
in a decoupled way through logical operations. We used this for our recipe entities as they all have an enum that allows users 
to search and sort based on the enum.
We used the filter command in order to easily allow our user to sort their list of recipes.  We used this
design pattern since we believed it would be useful to create individual classes to filter our recipe list depending
on each recipe category we have listed (following SRP). Also, since we can simply implement a new filter class whenever
we want to add a new recipe category we are also closely following OCP. In addition, we've integrated the pattern with
enums in order to easily keep track of the new categories we include for recipes.
We used the filter pattern to make a sorter for our user's recipe list.

