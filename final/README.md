
## What problem does your project solve?
My project is an IT ticket system (basic one). It allows people to use tickets to report issues.

## Why did you choose this data structure?
I chose a (FIFO) Queue because the first ticket in the queue, is the one that has been there the longest, and so it probably should be addressed first.

## What challenges did you encounter?
For me the main challenge was writing a good and functional command line interface. Ideally I would be using something like GNU Readline for this, but that is a C library, and I don't want to mess with bindings for it.

## What would you add if you had another week to work on it?
I would probably make a more robust data structure for this. One which allows you to have the first one in the queue, not be the first added one, but the one with highest priority. Priority would be more complicated than just LOW MEDIUM HIGH EMERGENCY, and would include time. I would also make it so not only the first one could be removed, but any of them, however they would be ordered in order of priority, encouraging higher priority tickets to be solved first. This sort of data structure would likely only appear like a normal data structure at first glance, however the way you index/access elements and their ordering, would be generating on the fly, and it would be backed by a different underlying data structure which actually houses the tickets.