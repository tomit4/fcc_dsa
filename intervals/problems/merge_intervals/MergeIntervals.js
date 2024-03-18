class Interval {
  constructor(start, end) {
    this.start = start;
    this.end = end;
  }
}

const intervals = [new Interval(7, 9), new Interval(2, 6), new Interval(1, 3)];

const mergeIntervals = (inters) => {
  if (inters.length < 2) return inters;
  const result = [];
  inters.sort((a, b) => a.start - b.start);
  const firstInterval = inters[0];
  let start = firstInterval.start;
  let end = firstInterval.end;
  for (let i = 0; i < inters.length; i++) {
    const current = inters[i];
    // we have overlapping intervals
    if (current.start <= end) {
      end = Math.max(current.end, end);
    } else {
      result.push(new Interval(start, end));
      start = current.start;
      end = current.end;
    }
  }
  result.push(new Interval(start, end));
  return result;
};

const mergedIntervals = mergeIntervals(intervals);
console.log("mergedIntervals :=>", mergedIntervals);
// mergedIntervals :=> [ Interval { start: 1, end: 6 }, Interval { start: 7, end: 9 } ]
