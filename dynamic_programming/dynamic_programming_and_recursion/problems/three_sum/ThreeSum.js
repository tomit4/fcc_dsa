let array = [2, 4, 3, 7, 1, 0];
let tgt = 6;

const threeSum = (arr = [], target) => {
  arr.sort((a, b) => a - b);
  // custom... removes all elements larger than target value
  // easy because arr is now sorted
  for (let i = arr.length - 1; i >= 0; i--) {
    if (arr[i] > target) {
      arr.pop();
    }
  }
  // keeps an initial pointer i, note the arr.length - 2 condition,
  // that's because once i has reached arr[arr.length - 2], the last two elements
  // have already been inspected by j and k
  for (let i = 0; i < arr.length - 2; i++) {
    // j always starts off the next index from j
    let j = i + 1;
    // and k from the end of the array
    let k = arr.length - 1;
    // move the two other pointers towards the middle of the remaining "sub-array"
    while (j < k) {
      const sum = arr[i] + arr[j] + arr[k];
      // and check if arr[j] and arr[k] when summed with arr[i] equal target
      if (sum === target) {
        console.log("three sum found :=>", `[${arr[i]}, ${arr[j]}, ${arr[k]}]`);
        // and move both are pointers
        j++;
        k--;
        // if the sum is less than the target value...
      } else if (sum < target) {
        // progress the left secondary pointer forwards,
        // as arr[j] is a lesser value in a sorted arr
        j++;
        // otherwise the sum is greater than the target, and arr[k],
        // being the higher value in a sorted arr, we move the end pointer towards the middle
      } else {
        k--;
      } // .. until j and k meet or cross
    }
  }
};

threeSum(array, tgt);
// three sum found :=> [0, 2, 4]
// three sum found :=> [1, 2, 3]
