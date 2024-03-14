const array = [9, 5, 2, 4, 3];

const merge = (arr = [], temp = [], low, mid, high) => {
  // make copy of array
  // (recall that low and temp change based
  // off of which level of recursion we're in)
  for (let i = low; i <= high; i++) {
    temp[i] = arr[i];
  }
  // see merge two sorted array for reference
  let i = low;
  let j = mid + 1;
  let k = low;
  // traverse both arrays(low and high) and compare them to the original
  // whichever one has the lower value populates our original array
  // (replacing it and thusly sorting it as it merges)
  while (i <= mid && j <= high) {
    if (temp[i] <= temp[j]) {
      arr[k] = temp[i];
      i++;
    } else {
      arr[k] = temp[j];
      j++;
    }
    k++;
  }
  // should one of our arrays have any elements remaining,
  // since it is already sorted by sort()
  // simply populate the remainder of our array with the remaining elements
  while (i <= mid) {
    arr[k] = temp[i];
    i++;
    k++;
  }
  return arr;
};

const sort = (arr = [], temp = [], low, high) => {
  // base case
  if (low < high) {
    // NOTE: technically (high - low) / 2 works for mid,
    // but low is added to ensure that if we go out of
    // range of one of the arrays, the mid does not return
    // a garbage value (an index that does not exist in the array)
    const mid = low + (high - low) / 2;
    // because we keep passing mid(or mid + 1) as either low or high...
    // we keep calling sort recursively until low = high (base condition above)
    // which evaluates basically to 2 or less elements in the smallest divided arrays
    sort(arr, temp, low, mid);
    sort(arr, temp, mid + 1, high);
    merge(arr, temp, low, mid, high);
  }
  return arr;
};

console.log(
  "sort(array, [], 0, arr.length - 1) :=>",
  sort(array, [], 0, array.length - 1),
);
// sort(array, [], 0, arr.length - 1) :=> [ 2, 4, 3, 9, 5 ]
