## Priority Queue

Priority Queue is a data structure that allows us to find minimum/maximum
elements among a collection of elements in constant time (O(1)). it supports the
following operations:

- insert(key) - insert a key into the priority queue.
- deleteMax()/deleteMin() - return and remove largest/smallest key.
- getMax()/getMin() - return largest/smallest key.

## Binary Heap

The binary heap is a data structure that helps us in implementing Priority Queue
operations efficiently. A binary heap is a complete binary tree in which each
node value is >= (or <=) the values of its children.

```
--------MIN HEAP-------
all values are <= the values of its children
          (0)
          / \
      (7)     (3)
      / \     / \
    (9) (8) (5) (6)

--------MAX HEAP-------
all values are >= the values of its children
          (9)
          / \
      (3)     (6)
      / \     / \
    (2) (1) (5) (4)
```

## Complete Binary Tree

A complete binary tree is a binary tree where all levels are completely filled
except for the last level. Additionally, the last level has nodes in such a way
that the left side is never empty.

```
--------COMPLETE BINARY TREE-------
          (0)
          / \
      (7)     (3)
      / \     / \
    (9) (8) (5)

--------INCOMPLETE BINARY TREE-------
          (9)
          / \
      (3)     (6)
      / \     / \
        (1) (5) (4)
```
