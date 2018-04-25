# AndroidBasicNanoDegree_Project5
PathAdvisor - Fantasy World's Largest Travel App

The project aimed to realize a tour app. I often find myself (and my player) lost in Pathfinder so I decided to tackle a sort of guide for that world. Obviously I could't represent even a crumb, but gives the idea of what could be done. 
The major obstacle to realize an actual feasible app (despite the amount of data to represent) is the data model: a database would improve A LOT the possibility as well as the readability of the project.

The main features are:
* All items are stored in the "All" category. 
* There are a total of five categories: Character, Cities, Inns, POI (Point Of Interest), and Shops.
* A single class can represent all data, so a single adapter class is used to represent items in other categories. It is the page adapter that takes care of filtering the list for each category. 
* Clicking on any item opens its detail page. 
* Some item have an "Owner". This is an example of viable relation between items. The owner itself can be clicked in the detail page to access to its own detail.

What could be further improved:
* As mentioned, the data model for the moment is quite poor. Opening the detail page passing the class itself is a bit reduntant (as the data gets duplicated) and could be improved even using a global variable or a singleton. (To be honest, I just wanted to experiment a bit with intent and serialization).
* Many relation might be added.
* The "Owner" (or other relation) might change to a list. That would add the challenge to represent them in the detail scrollview.

**N.B.:** The /credits.txt files stores all resource original sources.
