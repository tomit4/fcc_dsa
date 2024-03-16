## What Is A Graph?

- A Graph Is a non-linear data structure used for storing data
- It is a set of <em>vertices</em> and a collection of <em>edges</em> that
  connects a pair of vertices

- In the below example 1, 2, 3, 4, 5 are the <em>Vertex</em> of a Graph and
  each line connecting them is called an <em>Edge</em>

```
    vertex --> (1) ------- (2)
          \     | \          \
           \    |  \          \
            \   |   \          \
             \  |    \          \
              \ |     \          \
              >(3)----(4)--------(5)
                    |        |
                   edge     edge
```

## Why Are Graphs Important?

Applications - Social Network

```
    people --> (Ankit) ------- (John)
          \     |     \             \
           \    |      \             \
            \   |       \             \
             \  |        \             \
              \ |         \             \
              >(Bill)----(Kathy)--------(max)
                       |        |
                       Friendship
```

- Graphs help us implement Social Networking sites such as, Facebook, Twitter,
  etc. It can be called a Social Networking Graph.
- Names of people represent vertices of a Graph.
- Friendships between two people can be represented as an Edge of a Graph.

Applications - Web Content Over The Internet

```
    webpage--> (google.com) ------- (udemy.com)
          \     |          \                    \
           \    |           \                    \
            \   |            \                    \
             \  |             \                    \
              \ |              \                    \
              >(youtub.com)----(twitter.com)--------(facebook.com)
                            |                  |
                           Link               Link
```

- Graphs help us organize web content over the internet
- Webpages such as google.com, udemy.com, etc. represent vertices of a Graph.
- A Link between two webpages can be represented as an Edge of a Graph.
