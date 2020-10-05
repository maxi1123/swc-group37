-----------
Task 1.1

** Refer to swc-group37\SoftCon2020_Assignment_1\Architecture Abstraction.png for the drawing **

We started with the class "Locales" in the package "com.kotcrab.vis.ui",
as we felt it was a good starting point to get a basic understanding of the architecture.
The class uses a solid amount of import statements and it relies on a lot of other packages,
which gave us a foundation to draw our abstraction. We decided to visualize the architecture
by using boxes and arrows. The boxes representing the packages are colored red, while we
use blue fields for the classes.
An incoming arrow indicates an import statement used by the respective class, while as an outgoing arrow indicates,
that the class is being imported elsewhere.

While our design works well to understand small portions of a software, it could get difficult to realize this on a larger scale,
due to the messy nature of imports and the resulting arrows. 

-----------
Task 1.2

** Refer to swc-group37\SoftCon2020_Assignment_1\Call Graph.png **
-----------
Task 2

** Refer to swc-group37\SoftCon2020_Assignment_1\Data Flow #1-#6.png **

!! Please note that calls to external library (java.util, java.io etc.) functions are not included due to simplicity !!

We decided to not follow the calls branching off at getJson(tokens) in the com.kotcrab.vis.usl.Parser package, as the graph
would become very messy and extremely in-depth.
-----------