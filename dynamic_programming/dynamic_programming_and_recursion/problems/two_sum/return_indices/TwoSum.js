const nums = [2, 11, 5, 10, 7, 8];
const targ = 9;

const twoSum = (numbers, target) => {
  const result = Array(2).fill(undefined);
  const map = new Map();
  for (let i = 0; i < numbers.length; i++) {
    if (!map.has(target - numbers[i])) {
      map.set(numbers[i], i);
    } else {
      result[1] = i;
      result[0] = map.get(target - numbers[i]);
      // map :=> Map(4) { 2 => 0, 11 => 1, 5 => 2, 10 => 3 }
      console.log("map :=>", map);
      return result;
    }
  }
  if (result.includes(undefined))
    console.error("ERROR :=> Two numbers not found", result);
};

const twoSumResult = twoSum(nums, targ);
console.log("twoSumResult :=>", twoSumResult);
// twoSumResult :=> [ 0, 4 ]
const falseArr = [2];
const falseTarg = 9;

const failingTwoSumResult = twoSum(falseArr, falseTarg);
console.log("failingTwoSumResult :=>", failingTwoSumResult);
