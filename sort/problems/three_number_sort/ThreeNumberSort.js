const array = [0, 0, 1, 2, 0, 1, 2];

const swap = (arr = [], i, j) => {
  const temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
};

const threeNumberSort = (arr = []) => {
  // establish three pointers, two at the beginning(i, j), one at the end(k)
  let i = 0;
  let j = 0;
  let k = arr.length - 1;
  // as long as the first pointer(i) hasn't traversed past the last(k)
  while (i <= k) {
    // if the value is 0...
    if (arr[i] == 0) {
      // swap the elements at arr[i] and arr[j]
      swap(arr, i, j);
      // and make sure to increment both(until the end
      // of the loop, j should always point to a 0)
      // if i also points to a 0, they need to swap,
      // as i should point to a 1
      i++;
      j++;
      // if we encounter a 1, simply increment i, as it
      // needs to then inspect the next unknown element
    } else if (arr[i] == 1) {
      i++;
      // however if we encounter a 2, it needs to be at
      // the end, so arr[i] needs to swap with arr[k]
    } else if (arr[i] == 2) {
      swap(arr, i, k);
      // and we need to decrement k to the previous unknown
      // element until both i and k cross, ending the loop
      k--;
    }
  }
};

threeNumberSort(array);
console.log("array:=>", array);
// array:=> [ 0, 0, 0, 1, 1, 2, 2 ]
