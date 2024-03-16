## Adjacency List Representation (Undirected Graph)

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

```
[
  [0] --> [ -> [1, ] --> [3, ] --> null  ]
  [1] --> [ -> [0, ] --> [2, ] --> null  ]
  [2] --> [ -> [3, ] --> [1, ] --> null  ]
  [3] --> [ -> [2, ] --> [0, ] --> null  ]
]
```

- An Adjacency List Can Be Represented As An Array Of Singly Linked Lists
- Notice the above two diagrams. In the first diagram, vertex 0 is connected to
  the vertices 1, and 3. The second diagram points out that 0 is represented as
  a linked list containing vertex 1, which also points to vertex 3 as it's next value.
