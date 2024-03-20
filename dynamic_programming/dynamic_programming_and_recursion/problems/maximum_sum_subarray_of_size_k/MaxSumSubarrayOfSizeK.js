// Example -
// Input: arr = [2, 7, 3, 5, 8, 1], k = 3
// Output: arr = 16

let array = [2, 7, 3, 5, 8, 1];
let k = 3;

// My solution (not good, time complexity O(n*k)) because of reduce() loop
let maxSumSubarrayOfSizeK = (array = [], k) => {
  let i = 0;
  let winCount = k;
  const results = [];
  while (i < array.length - k + 1) {
    const windowArr = array.slice(i, winCount);
    const windowSum = windowArr.reduce((a, b) => a + b, 0);
    results.push(windowSum);
    i++;
    winCount++;
  }
  const max = Math.max(...results);
  return max;
};

let answer = maxSumSubarrayOfSizeK(array, k);
console.log("answer :=>", answer);
// answer :=> 16

// Tutorial Answer (better solution, O(n))
maxSumSubarrayOfSizeK = (arr = [], k) => {
  let maxSum = 0;
  let windowSum = 0;
  let start = 0;
  for (let end = 0; end < arr.length; end++) {
    // windowSum at the beginning of this loop
    // is always equal to the sum of all but the first element of
    // the last subarray before traversing down the arr
    windowSum = windowSum + arr[end];
    // if we traverse one over the subarray
    // window length, start adjusting maxSum
    if (end >= k - 1) {
      // compare the sum of the subarray thus far to maxSum
      // and assign the  result to maxSum
      maxSum = Math.max(maxSum, windowSum);
      // the windowSum then subtracts the first element
      // of the subarray in preparation for the beginning of this for loop
      windowSum = windowSum - arr[start];
      start++;
    }
  }
  return maxSum;
};

answer = maxSumSubarrayOfSizeK(array, k);
console.log("answer :=>", answer);
// answer :=> 16
