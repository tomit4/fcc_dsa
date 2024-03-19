const array = [11, 2, 0, 10, 7, 6];

const twoSum = (arr = [], target) => {
  arr.sort((a, b) => a - b);
  let left = 0;
  let right = arr.length - 1;
  const result = Array(2).fill(undefined);
  while (left < right) {
    const sum = arr[left] + arr[right];
    if (sum === target) {
      result[0] = arr[left];
      result[1] = arr[right];
      return result;
    } else if (sum < target) {
      left++;
    } else {
      right--;
    }
  }
  return [];
};

const twoSumSolution = twoSum(array, 9);
console.log("twoSumSolution :=>", twoSumSolution);
// twoSumSolution :=> [ 2, 7 ]
