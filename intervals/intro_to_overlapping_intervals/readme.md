## Introduction To Interval

- An interval is a range reprsented by two numbers like (5, 8)
- The two numbers are termed as - <em>start</em> and <em>end</em>.

- Example - Time interval in tasks or jobs -
  a => (1,3), b => (4,5), c => (8,10) and d => (9,11)

```
0  1   2   3   4   5   6   7   8   9  10  11
---|---|---|---|---|---|---|---|---|---|---|--> time axis
   [  1,3  ]   [4,5]           [  8,10 ]
       a         b                 c
                                   [  9,11 ]
                                       d
```

NOTE: Usually intervals are used when referencing time

## Interval Representation

```java
public class Interval {
    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
```

## Overlapping Intervals

Overlapping Intervals are simply at least 2 intervals that overlap over their
common axis. In the example above we see that intervals c and d overlap, whereas a and b do not.
Thusly Overlapping Intervals can be defined as:

- Having a Relationship between at least two intervals <em>a</em> and
  <em>b</em>, where at least one of their elements within one interval's range
  exists within the other interval.

Examples that demonstrate Overlapping Intervals:

1. a and b do not overlap: a => (1,3), b => (4,5)
2. a and b overlap, with b ending after a: a => (1,4), b => (3,6)
3. a completely overlaps b: a => (1,6), b => (2,4)
4. a and b overlap, with a ending after b: a => (3,6), b => (6,9)
5. b completely overlaps a: a => (2,4), b => (1,6)
6. b and a do not overlap: a => (1,3), b => (4,5)
