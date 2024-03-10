## What is a Circular Singly Linked List?

- Its similar to a Singly Linked List, with the difference being that in
  a Circular Linked List the last node points to the first node and not null
- Instead of head, we keep track of the last node in a Circular Singly Linked
  List

```
--------------- SINGLY LINKED LIST ----------------
head
  |
[1, ] --> [8, ] --> [10, ] --> [16, ] --> null
----------- CIRCULAR SINGLY LINKED LIST -----------
                                              last
                                               |
-->[1, ] --> [8, ] --> [10, ] --> [16, ] --> [1, ]-->|
|                                                    |
------------------------------------------------------
```
