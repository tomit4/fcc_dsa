## Quick Sort

- Quick Sort is a divide and conquer algorithm. It involves 3 steps:

1. Pivot Selection - We pick an element and mark it as a pivot. The pivot
   element can be the first element, the last element, or any random element.
2. Partitioning - We reorder the array such that all elements greater than the
   pivot comes after the pviot and all elements smaller than the pivot comes
   before the pivot. The elements equal to the pivot can go on either side of
   the pivot. After this partitioning, the pivot is at its correct sorted
   position.
3. Recursion - Recursively apply the above steps on the subarray formed to the
   left side of the pivot and on the subarray formed on the right side of the
   pivot.
