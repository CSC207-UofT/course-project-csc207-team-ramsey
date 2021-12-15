## Accessibility Report


### Adherence to Universal Design Principles
Given that our application uses a command line interface, there is limited adherence
to some universal design principles throughout the program. However, this document will address some positive 
universal design aspects of our program as well as the major detriments
of using a CLI for our user. We will also discuss how these design principles can be  leveraged to improve our CLI
and how they can be used to transition into a more equitable graphical user interface in android, where each UDP could be 
related to user experience design principles.


#### 1) Equitable Use

The equitable use principle states that the design should be useful and marketable to people with diverse abilities. 
This design principle suggests that users should receive the same interaction with the application whenever possible so
that users will not be segregated or stigmatized. All users should receive relatively equivalent privacy, safety, and security
features. The interface design should also be equally appealing and aesthetically pleasing to all users. 

We tried
to ensure that the users of the program have sufficient control and freedom over their app by creating commands that
allow users to remove the changes they have made, such as with the 'delRecipe' and 'delFood' commands. Furthermore, with
only one type of user implemented, Ricetta does not give extra privileges to any particular users. What could be improved
to remove barriers to entry for Ricetta in terms of the CLI are clarity and language support. Ricetta has only been 
implemented in English, and would not be usable for a large portion of the population. Overall, by implementing a GUI,
the barrier for entry for Ricetta would be lowered significantly, with graphics assisting many users who do not have a firm
grasp of English. 


#### 2) Flexibility in use

The flexibility in user principle requires the accommodation for a wide range of preferences and abilities in the app. So, this
principle would be relevant for the inclusion of disabled users, which could be achieved by providing optional methods of 
interaction and facilitating the accuracy and precision of user interaction. For Ricetta, the use of the app is not very flexible
at this stage. With a CLI, inputs into the app need to be specific and intentional with little to no variation to interaction.
Disabled users could have a hard time using Ricetta; however, with a GUI, improved visibility of system status could make 
using Ricetta much more simplistic. Inputs could be registered through the push of a button or through voice command.


#### 3) Simple and Intuitive Use

The simple and intuitive use principle states that the developer should create designs that are easy to use and understand
for all users, regardless of experience, knowledge, language skills, or concentration. As a CLI, Ricetta is not very intuitive.
It requires the user to have appropriate understanding of the available commands for efficient use. The current interface
does not model systems on the real world and, therefore, does not allow users to immediately comprehend how to effectively 
interact with the app. Furthermore, a significant cognitive load is required for initial app use, as information is primarily
conveyed through text. Implementing a GUI would make Ricetta more intuitive by eliminating the need for by providing further
detail that our current text-based interface can provide.


#### 4) Perceptible information

The perceptible information principle states the design should learly and effectively communicate all information 
which is necessary for the user, regardless of the conditions or sensory ability of the user. This can be achieved by 
using different methods to represent information and increasing overal legibility of test-based information. For our CLI,
we maintained simple language, often listing available option to the user concisely when required. However, this method of 
conveying information was not diverse enough to maximize perceptability. In a GUI, pictures and formatted charts can be used
to properly display our Entities and differentiate various elements of the program, and charts can be used to quickly display
some details for the Entities. 


#### 5) Tolerance for Error

This principle requires the design minimize hazards for the users adverse actions. In the CLI, we attempted to follow this 
principle by creating delete commands for every create command we make. So, every modification that a user adds to the app is 
reversible. To improve this capability in the CLI, we could implement an undo method in our Commands to make each command directly
reversible (even for our delete commands). We could also use the Momento design pattern to allow users to backtrack to certain 
program states. Our CLI, also gives the user various warnings whenever their inputs do not follow. This undo method, would translate 
to an undo button in our GUI. However, the GUI can also minimize hazards by making information more 

#### 6) Low physical effort

This principle demands that the developer ensures users can use the design both efficiently and comfortably without fatigue.
As a CLI this principle is not adhered perfectly in our program. The user is required to perform several repetitive tasks
through our commands which are significantly mentally taxing.

#### 7) size and space for approach and use

This requires  that the designer provides appropriate sizing and spacing for user interaction regardless of body size and mobility.
The program is mostly accessibly for different body types; however, it is not physically accessible for individuals with low finger dexterity. 


### Target Market

The target demographic of our app are consumers who cook on a regular basis, typically young adults, university students,
cooking hobbyist, or home cooks who want an easy way to manage their recipes and food supply. So, this is the user we have in mind
while considering R&D, pricing, promotional material, and product placement. The initial CLI we use in our app can be 
used effectively for most of our target market, who are relatively young and tech-savvy. However, further R&D will be used in order 
to improve accessibility and follow UDP as well as develop on an OS which is more easily marketable to our target
consumer(Android, IOS). 


### Other Demographic Considerations

This program is less likely to be used for the younger and older demographic, as they may either not have proper acess to 
technology or do not have the technical expertise to use the app. Also, people who do not cook at home will not have the need for 
Ricetta. Of note, as a CLI, the limited accessibility makes the app to be easily used by many demographics at this stage; however,
these considerations will be taken into consideration for further iterations of the app. 