## Merge Sort

- Merge Sort is a divide and conquer algorithm.

> Divide and Conquer recursively breaks down a problem into two or more
> sub-problems of the same or related type, until these become simple enough to be
> solved directly. The solutions to the sub-problems are then combined to give a
> solution to the original problem. -Wikipedia

- Divide - In this step the algorithm takes a middle point of an array and
  divides the array into 2 halves. The agorithm is carried out recursively for the
  halved arrays, until there are no more halved arrays to divide.
- Conquer - In this step, starting from the "bottom", we sort and merge the
  divided arrays and return the sorted array.

NOTE: On further inspection, this would be more aptly named "Divide and Combine"
