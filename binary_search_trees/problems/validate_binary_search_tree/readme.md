## Problem Statement

Q. Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

1. The left subtree of a node contains only nodes with keys less than the node's key.
2. The right subtree of a node contains only nodes with keys greater than the node's key.
3. Both the left and right subtrees must also be binary search trees.

```
root -->      (6)
             /   \
           (4)   (8)
          /  \   /  \
        (2) (5) (7) (9)
```
