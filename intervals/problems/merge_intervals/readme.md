## Problem Statement

Q. Given a list of intervals, merge all the overlapping intervals and return a
list of non-overlapping intervals.

Example -
Input: intervals = [[2, 6],[1, 3],[8, 10]]
Output: [[1, 6],[8, 10]]

Steps:

1. Sort the intervals based on start time. (a.start <= b.start)
2. c.start = a.start
3. c.end = Math.max(a.end, b.end)
4. Repeat for all overlapping intervals

References:

- https://scribe.rip/m/global-identity-2?redirectUrl=https%3A%2F%2Fjavascript.plainenglish.io%2Fjavascript-algorithms-merge-intervals-leetcode-98da240805bc
