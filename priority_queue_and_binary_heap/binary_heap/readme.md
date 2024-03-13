## Representation Of A Binary Heap

- Binary Heaps usually are implemented using arrays.
- The first entry of an array is taken as empty.
- As Binary Heaps are complete binary trees, the values are stored in an array,
  and are traversed in leve order and from left to right.

```
--------MAX HEAP-------
          (9)
          / \
      (3)     (6)
      / \     / \
    (2) (1) (5) (4)

--------HEAP AS ARRAY-------
[null, 9, 3, 6, 2, 1, 5, 4]
        heap[]
```
