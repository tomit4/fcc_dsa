Q. Given a matrix, print it in spiral form.

```
    ---------------------
      0    1    2    3
  0 | 1  | 2  | 3  | 4  |
  1 | 5  | 6  | 7  | 8  |
  2 | 9  | 10 | 11 | 12 |
  3 | 13 | 14 | 15 | 16 |
    ---------------------
          matrix[][]
```

NOTE: Essentially the task is to print each element of the matrix first
traversing the outermost row, then down the last column until the last element,
then backwards towards the last row, first column, then upwards until
the second row, then rightwards until the second to last column, then
downwards until the second to last row, and so on.
