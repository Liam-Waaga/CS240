

## What was the most challenging method to implement, and why?
For me it was the delete method. While writing this program, it was among the easiest, but that was because i just adapted it from a previous BST implementation I wrote. Overall, I think that writing that method was harder than writing all the other methods here, simply because of how much I need to take into consideration and how many edge cases there are.

## How does the structure of your tree reflect the data being managed?
The tasks are organized such that there priority makes lower priority ones be farther "left", and higher priority ones farther "right". When using inorder traversal, it shows the tasks in the reverse order of there priority, low to high (when printing). It is very easy to also remove the task with the highest priority, as well as peak at it.

## What did you learn about how data structures affect problem modeling?
Selecting what data structure to use can easily effect how you think about the problem. If we were using an array for example, then we would have a lot of moving around of data, even though it may seem more intuitive at first. Once we decided to use a BST it is easy to see how a tasks priority represents where it will be in the tree.

## Do you feel more confident implementing your own data structures now? Why or why not?
I do, after implementing tree like structures several times, I am confident in at least this kind of data structure. I also feel more confident manipulating data in an organizational manner, making efficient data structure implementations seem more natural.