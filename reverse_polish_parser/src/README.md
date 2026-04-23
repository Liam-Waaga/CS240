## 1 How does the recursive structure of your solution align with the left-to-right nature of prefix notation?
My solution goes through and when it encounters an operator, it will recursively make a new parsed expression and then continue at the end of the sub expression. I used a binary tree which is ideal for recursive operations, as each node is its own tree, allowing me to evaluate each node as if it were its own tree, and having a base case for constants.

## 2 What other data structures that you know of so far could you use to manage your tokens?
I used a binary tree to organize my tokens. It is possible other sorts of tree could be used however I determined that a binary tree would be best because these are all binary operators.

## 3 In what ways is this different from parsing an infix expression recursively?
The main difference is that with infix people often assume that pemdas is being followed. If we ignore pemdas, then I could switch 2 lines of code and have a working infix parser, by simply changing where I expect the operator to be. Allowing the lhs to be parsed first as its own sub expression, rather than after determining the operator.

## 4 Did you run into anything during the assignment about which you still have questions or do not fully understand?
Not really. This was sort of confusing at first as I thought of the best way to go about it, but once I got a fully formed idea of the implementation it was smooth sailing. What helped though was a video I watched a while ago about a form of parsing called Pratt Parsing, which is a way of parsing complex expressions (typically infix) while following operator precedence rules.