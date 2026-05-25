## What is the most challenging part of managing links in a circular doubly linked list?
For me it is managing head and tail. I can make a list, where all the objects are in a circle, in the correct order. However, making sure that head is the right node and tail is the right node is the most challenging part.

## How did you ensure your list stayed circular and doubly linked after insertions and deletions?
For me, I made sure to always assign x (the new element) to be the next of something, and the previous of something. When dealing with head and tail, I made sure to set tail to head.prev and make sure head.prev is index size-1.

## What are the advantages and disadvantages of this structure compared to a regular linked list or array list?
This allows for easy end and beginning access, insertion, and deletion. It also allows iteration to go by relatively quickly if that feature is added to the structure implementation.

## What questions or uncertainties do you still have about linked list implementations?
I am relatively comfortable with LL's and other sparse data structures. For me the difficult part is understanding the nuances of each data structure, and for an LL, the nuances are basically just "it's an array but sparse". With circular lists, it is a bit more difficult, but the structure is intuitive to me. These serve as a good baseline when introducing trees and other more complex sparse data structures.