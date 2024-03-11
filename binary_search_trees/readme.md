## What Is A Binary Search Tree?

- It is a type of Binary Tree in which data is organized in an ordered manner
  which helps in faster search and insertion of data. It satisfies the following
  properties:

1. The left subtree of a node contains only nodes with values lesser than the
   node's value.
2. The right subtree of a node contains only nodes with values greater than the
   node's value.
3. The left and right subtree each must also be a binary search tree.

```
---------------BST-----------------
               (6)
              /   \
           (4)     (8)
          /  \     /  \
        (2)  (5) (7)  (9)
```

```
-------------NOT BST---------------
8 is greater than 6, and thusly does not follow the constraints of a BST

               (6)
              /   \
           (4)     (8)
          /  \     /  \
        (2)  (8) (7)  (9)
```

```
-------------NOT BST---------------
3 is less than 6, and thusly does not follow the constraints of a BST
               (6)
              /   \
           (4)     (8)
          /  \     /  \
        (2)  (5) (3)  (9)
```

NOTE: Very essentially, it's a sorted binary tree, where the left child node's
values are always lesser than the parent node's value, and the right node's
value are greater than the parent node's value. This applies down the entire
tree.

```

```
