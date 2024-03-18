class Interval {
  constructor(start, end) {
    this.start = start;
    this.end = end;
  }
}

let intervals = [
  new Interval(0, 1),
  new Interval(3, 5),
  new Interval(6, 7),
  new Interval(9, 10),
];

const newInter = new Interval(2, 6);

const insertInterval = (inters = [], newInter) => {
  if (!inters.length) {
    inters.push(newInter);
    return inters;
  }
  const result = [];
  // NOTE how i is incremented across three while loops here...
  let i = 0;
  // first we see if there aren't any overlapping intervals and add them to the result[]
  while (i < inters.length && inters[i].end < newInter.start) {
    result.push(inters[i]);
    i++;
  }
  // check if any interval's start is less than OR EQUAL
  // to the new interval's end, this is important as if any
  // interval's end is touching the start of any element, we want them to merge
  while (i < inters.length && inters[i].start <= newInter.end) {
    const current = inters[i];
    newInter.start = Math.min(current.start, newInter.start);
    newInter.end = Math.max(current.end, newInter.end);
    i++;
  }
  // before moving on, we want to add the new interval at this point
  result.push(newInter);
  // if there are any remaining non-overlapping intervals,
  // we simply want to push them to the result[]
  while (i < inters.length) {
    result.push(inters[i]);
    i++;
  }
  return result;
};

intervals = insertInterval(intervals, newInter);
console.log("intervals :=>", intervals);
/*
intervals :=> [
  Interval { start: 0, end: 1 },
  Interval { start: 2, end: 7 },
  Interval { start: 9, end: 10 }
]
*/
