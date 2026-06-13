
## What is the base case in your recursive method, and why is it necessary?
Well there were a few recursive methods, but in principle, the base case is there to provide an initial value. If there wasn't one, the recursive method would go searching forever for one (except for void recursive methods, which simply stop recursing at the base case).

## How does the recursive structure of your solution align with the problem structure?
Because of the nature of AVL Trees, each sub tree is a full AVL tree. So when we are performing operations on it, it is natural to use recursion to perfom an operation on each sub tree until we reach a natural base case.

## What are some limitations or tradeoffs of using recursion in this context?
As is always the case with recursion, it is possible it is slower. However in this case the more pressing issue is recomputation of values such as height. When we calculate height for example, we might be tempted to use the simple recursive height method to get the height of the tree. However, if we are doing this over and over, we begin to recalculate the height many times. This is why we have height stored as a property of the node, and updating it only when it changes. Recursion can also make it difficult if we need to do anything above the current recursive context.

## Did you run into anything during the assignment that you still have questions about or do not fully understand?
I understand how an AVL tree works, however what I don't fully understand is how our balancing operation ensures a fully balanced tree at the end. I get the small scale, but I don't get how once it is put together, it can account for every possible scenario, while being as simple as it is.