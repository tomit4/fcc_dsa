## What Is An Undirected Graph?

```
    vertex --> (0) ------- (1)
          \     | \          \
           \    |  \          \
            \   |   \          \
             \  |    \          \
              \ |     \          \
              >(3)----(4)--------(2)
                    |
            undirected edge
```

- Example - Social Networking Graph is an undirected graph
- If John (vertex) is friend (edge) to Max (vertex), then Max (vertex) is also
  friend (edge) to John(vertex)

```
   (John) ------------> (Max)
           Friendship
# is the same as:
   (Max) ------------> (John)
           Friendship
# the nature of the edge is undirected
```

## Adjacency Matrix Representation (Undirected Graph)

Here we see a simple Undirected Graph with 4 vertices and 4 edges, we can
represent this as a 4x4 matrix

```
   (0) ------------- (1)
    |                 |
    |                 |
    |                 |
    |                 |
    |                 |
   (3) ------------- (2)
      Undirected Graph
```

Here we have our 4x4 matrix, where 0 represents the absence of an edge,
while 1 represents the presence of an edge

```
       (0)  (1)  (2)  (3)
   (0)  0    1    0    1
   (1)  1    0    1    0
   (2)  0    1    0    1
   (3)  1    0    1    0
      Adjacency Matrix[][]
```

The following diagram simply reiterates the point that if an edge exists between
two vertices, we represent that in our adjacency matrix with a 1, and an absence
with a 0

```
              1
(row) ----------------- (col)

              0
(row)                   (col)

```
