## Problem Statement

Q. Given an array of integers `arr`, there is a sliding window of size `k` which
is moving from the very left of the array to the very right.
Find the maximum sum of any contiguous subarray of size `k`.

Example -
Input: arr = [2, 7, 3, 5, 8, 1], k = 3
Output: arr = 16

```
Window position             Sum
[2 7 3] 5 8 1                12
2 [7 3 5] 8 1                15
2 7 [3 5 8] 1                16
2 7 3 [5 8 1]                14
```
