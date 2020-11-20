# Task 1
--------------
Singleton:

We implemented two Singleton objects in our version of Battleships.
When running the main method, the game gets set up. Apart from the different grids being created, we need a
(single) player object as well as a (single) enemy object. These get created by making use of the Singleton
design pattern. Check lines 23 & 24 in AirportShuttle.Main.java for further reference. 
Theoretically this design pattern could've also been used for ensuring creation of a single scoreboard object.
However, we didn't want to overuse this pattern, hence we decided to not make use of another Singleton.

Iterator & Observer

Our group faced problems with the other two design patterns. Although being aware, where this design pattern 
could've been useful, we decided to not implement it. 
The ship's coordinates are stored in the object internally by making use of an ArrayList, which gets extended
upon ship placement. When looking at the Playflow class we're iterating through the different coordinate lists, by
making use of an old fashioned for-loop. 
When considering algorithm complexity, our chosen method surely isn't optimal and we are well aware of that. This
is where the iterator design pattern could have been an improvement. 
However, due to the general complexity of the given task we just didn't feel confident enough to mess with a different method
of iteration just yet.

Same for the observer. This design pattern clearly would've been useful to monitor destroyed ships. However, we
didn't get the feeling that we would've implemented it correctly without flaws.
It would have led to further complications, which is why we decided to go for a more simple approach.

Also from the assignment description it wasn't really clear if we MUST implement them or if we are free to choose
a different approach, if the former doesn't work out as expected. 
In the end we set our focus on coding a working game, which we did accomplish and we're very
proud, as this is the first sort of "connected" software we ever had to build during our studies at the university.
--------------
