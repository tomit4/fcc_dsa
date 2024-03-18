## Problem Statement

Q. Given an integer array called `nums`, return `true` if any value appears at
least twice in the array, and return `false` if every element is distinct.

## Examples

Input: [1, 2, 3, 1]
Output: true

Input: [1, 2, 3, 4]
Output: false

NOTE: Obviously, due to this being in the hash tables section, we don't want to
simply compare elements one by one, as that is O(n^2) time, we want to try and
solve it in O(1) time

We of course could simply sort the array, which would result in an O(n log n)
solution, which is slightly better, but not by much.
