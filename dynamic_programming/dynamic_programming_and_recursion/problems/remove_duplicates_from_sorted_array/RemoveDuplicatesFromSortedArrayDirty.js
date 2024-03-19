// While good on time complexity (O(n)),
// bad on space complexity, as it requires
// the initialization of another array.

let numbers = [1, 1, 2];

const removeDuplicatesFromSortedArray = (nums) => {
  const unique = [];
  for (let i = 0; i < nums.length; i++) {
    if (!unique.includes(nums[i])) {
      unique.push(nums[i]);
    }
  }
  return unique.length;
};

let numOfUniqueNums = removeDuplicatesFromSortedArray(numbers);
console.log("numOfUniqueNums :=>", numOfUniqueNums);
// numOfUniqueNums :=> 2

numbers = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4];
numOfUniqueNums = removeDuplicatesFromSortedArray(numbers);
console.log("numOfUniqueNums :=>", numOfUniqueNums);
// numOfUniqueNums :=> 5

// Built in JS methods for quick and dirty method
const removeDuplicatesFromSortedArrayDirty = (nums) => {
  return Array.from(new Set(nums)).length;
};

numOfUniqueNums = removeDuplicatesFromSortedArrayDirty(numbers);
console.log("numOfUniqueNums :=>", numOfUniqueNums);
// numOfUniqueNums :=> 5
