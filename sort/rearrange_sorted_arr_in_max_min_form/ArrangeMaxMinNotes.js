const array = [2, 3, 5, 6, 8, 9];

// Recall our constraint that our solution must run with time O(n) and space O(1),
// thusly our solution cannot return a new array, it MUST modify the input array
const arrangeMaxMin = (arr = []) => {
  // Two pointers, one at the end of the array (maxIdx)
  maxIdx = arr.length - 1;
  // and one at the beginning of the array (minIdx)
  minIdx = 0;
  // Our last element + 1 will be our max,
  // this is important as it gives us a reference to
  // perform modulus and division operations on to determine our min and max values
  max = arr[maxIdx] + 1;
  for (let i = 0; i < arr.length; i++) {
    // All Even Indexed Array Elements Will Hold Our Max Values
    // (starting with our last element, as our arraay is sorted)
    if (i % 2 === 0) {
      arr[i] = arr[i] + (arr[maxIdx] % max) * max;
      maxIdx--;
    } else {
      arr[i] = arr[i] + (arr[minIdx] % max) * max;
      minIdx++;
    }
  }
  for (let i = 0; i < arr.length; i++) {
    arr[i] = Math.floor(arr[i] / max);
  }
};

arrangeMaxMin(array);
console.log("array :=>", array);
// array :=> [ 9, 2, 8, 3, 6, 5 ]
