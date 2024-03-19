const array = [4, 3, -2, 6, -12, 7, -1, 6];

const maxSubArraySum = (arr = []) => {
  let maxSoFar = arr[0];
  let currentMax = arr[0];
  for (let i = 1; i < arr.length; i++) {
    currentMax = currentMax + arr[i];
    // should I start a new subarray?
    if (currentMax < arr[i]) {
      currentMax = arr[i];
    }
    if (maxSoFar < currentMax) {
      maxSoFar = currentMax;
    }
  }
  return maxSoFar;
};

let maxOfArray = maxSubArraySum(array);
console.log("maxOfArray :=>", maxOfArray);
// maxOfArray :=> 12

const maxSubArraySumAlt = (arr = []) => {
  let maxSoFar = arr[0];
  let currentMax = arr[0];
  for (let i = 1; i < arr.length; i++) {
    currentMax = Math.max(currentMax + arr[i], arr[i]);
    if (maxSoFar < currentMax) {
      maxSoFar = currentMax;
    }
  }
  return maxSoFar;
};

maxOfArray = maxSubArraySumAlt(array);
console.log("maxOfArray :=>", maxOfArray);
// maxOfArray :=> 12
