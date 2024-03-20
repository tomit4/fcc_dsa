## Problem Statement

Q. Given an array of integers `arr`, there is a sliding window of size `k` which
is moving from the very left of the array to the very right. You can only see
the k numbers in the window. Each time the sliding window moves right by one
position. Return the max sliding window.

Example -
Input: arr = [44, 77, 33, 44, 88, 11], k = 3
Output: arr = [77, 77, 88, 88]

```
Window Position               Max
[44 77 33] 44 88 11           77
44 [77 33 44] 88 11           77
44 77 [33 44 88] 11           88
44 77 33 [44 88 11]           88
```
