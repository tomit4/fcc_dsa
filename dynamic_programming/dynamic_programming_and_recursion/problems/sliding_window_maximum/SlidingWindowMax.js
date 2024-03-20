let array = [44, 77, 33, 44, 88, 11];
let k = 3;

// My solution
const slidingWindowMax = (array = [], k) => {
  let i = 0;
  let winCount = k;
  const results = [];
  while (i < array.length - k + 1) {
    let windowArr = array.slice(i, winCount);
    results.push(Math.max(...windowArr));
    i++;
    winCount++;
  }
  return results;
};

let answer = slidingWindowMax(array, k);
console.log("answer :=>", answer);
// answer :=> [ 77, 77, 88, 88 ]

// Tutorial Solution
const nextGreaterElement = (arr = []) => {
  const result = Array(arr.length);
  const stack = [];
  for (let i = arr.length - 1; i >= 0; i--) {
    if (stack.length !== 0) {
      while (stack.length !== 0 && arr[i] >= arr[stack[stack.length - 1]]) {
        stack.pop();
      }
    }
    if (stack.length === 0) {
      result[i] = arr.length;
    } else {
      result[i] = stack[stack.length - 1];
    }
    stack.push(i);
  }
  return result;
};

const maxSlidingWindow = (arr = [], k) => {
  const ngeArr = nextGreaterElement(arr);
  result = [];
  for (let i = 0; i <= arr.length - k; i++) {
    j = i;
    while (ngeArr[j] < i + k) {
      j = ngeArr[j];
    }
    result.push(arr[j]);
  }
  return result;
};

answer = maxSlidingWindow(array, k);
console.log("answer :=>", answer);
// answer :=> [ 77, 77, 88, 88 ]
