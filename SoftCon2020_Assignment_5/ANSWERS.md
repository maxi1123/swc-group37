#Exercise 1
--------
For the first exercise, the composite pattern was implemented on the offices
and bakeries, which were classified as "Entity" components, to facilitate easier operations
on the organizational structure. The tree-like structure of the organization led us to believe,
that the composite pattern is the most fitting one for this use case. This also enables easy additions
and expansions in the future due to the code structure.

The decorator pattern was applied twice: once for the sandwiches and once for the cakes. Each of their
decorator classes serve as a super class for each ingredient. This allows us to customize
every single food item instead of making a specific class for each type of cake/sandwich. This
can also be easily extended for further ingredients by inheritance from the respective dcorator classes.