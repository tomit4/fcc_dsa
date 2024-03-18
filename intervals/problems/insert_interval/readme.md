## Problem Statement

Q. Givena list of non-overlapping intervals sorted by their start time, insert
a given interval at the valid position, merge all the overlapping intervals and
return a list of mutually exclusive intervals.

Example -

Input: intervals = [[1, 3], [5, 7], [8, 10]], newInterval = [4, 9]
Output: [[1, 3], [4, 10]]

Sample Scenarios:

1. a and b do not overlap, so simply insert a
2. a and b do overlap, so we must compare their start and end values to
   determine if we:

   3. a's start is less than b's start, so the new interval must start with a's
      start,
      and also b's end is greater than a's end, so the new interval must end
      with b's end.

   4. likewise if b's start is less than a's start, then the new interval must
      start with b's start,
      and also a's end is therefore greater than b's end, so the new interval
      must end with a's end.

   5. a completely overlaps b, in which case we simply return a
   6. or of course, b overlaps a, in which case we simply return b
