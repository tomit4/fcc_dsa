## Bottom-up Reheapify Max Heap

- A Max heap is a complete binary tree in which each node value is >= the values of its children.
- After inserting an element into the heap, it may not satisfy the above heap
  property (max heap property). Thusly, we perform what is called a "bottom-up reheapify" technique, in which we adjust the locations of the heap elements to satisfy the Max Heap property.

```
--------MAX HEAP-------
          (9)
          / \
      (3)     (6)
      / \     / \
    (2) (1) (5) (4)
```

NOTE: See slides in this directory.
