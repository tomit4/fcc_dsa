## Breath First Search of an Undirected Graph

This readme is mostly written by myself, the tutorial series is starting to get
complex and I thought I'd take a moment to address the similarities between
graphs and trees given that they both involve methodologies like breath first search.

Take this Undirected Graph:

```
(0) ---------- (1)
 |              |
 |              |
 |              |
(3) ---------- (2) ---------- (4)
```

Now, given the instructor's explanation of how breath first search works, our
graph can be represented in a binary tree like so:

```
        (0)
        / \
      (1)  (3)
      /
    (2)
    /
  (4)
```

But because it's a graph, and it's not a tree, it can also be thought of like
so:

```
        (0)
        / \
      (3)  (1)
      /
    (2)
    /
  (4)
```

The important thing to remember is that we are doing breath first search on a
graph, so the concepts are not quite the same as breath first search on a tree.
However, they have similarities in that since we are performing a breath first
search, we are searching BY LEVEL.
