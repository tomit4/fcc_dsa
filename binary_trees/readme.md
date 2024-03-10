## What Is A Tree?

- It's a non-linear data structure used for storing data
- It is made up of nodes and edges without having any cycle
- Each node in a tree can point to n number of nodes in a tree
- It is a way of representing hierarchical structure with a parent node called
  as root and many levels of additional nodes

```
root -->          [1]
                 / | \
                /  |  \
              [2] [9] [3]
              / \     / \
             /   \   /   \
leaf -->    [4] [5] [6]  [7]
```

## Wha Is A Binary Tree?

- A tree is called a Binary Tree if each node has zero, one, or two children,
  and NO MORE.

```
root -->          [1]
                 /   \
                /     \
              [2]     [3]
              / \     / \
             /   \   /   \
leaf -->    [4] [5] [6]  [7]
```

```
---------------TreeNode----------------
null <-- [left][data][right] --> null
```

```
------------Graphical Form-------------
                (data)
               /     \
```
