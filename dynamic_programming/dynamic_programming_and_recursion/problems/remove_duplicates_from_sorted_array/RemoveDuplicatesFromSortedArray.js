let numbers = [1, 1, 2];

const removeDuplicatesFromSortedArray = (nums) => {
  let i = 0;
  for (let j = 0; j < nums.length; j++) {
    // simply look at each two elements,
    // if the previous element is different from the current element,
    // then copy the current element to the previous position, and incrment i
    if (nums[j] !== nums[j - 1]) {
      nums[i] = nums[j];
      i++;
    }
  }
  return i;
};

let numOfUniqueNums = removeDuplicatesFromSortedArray(numbers);
console.log("numOfUniqueNums :=>", numOfUniqueNums);
// numOfUniqueNums :=> 2

numbers = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4];
numOfUniqueNums = removeDuplicatesFromSortedArray(numbers);
console.log("numOfUniqueNums :=>", numOfUniqueNums);
// numOfUniqueNums :=> 5
