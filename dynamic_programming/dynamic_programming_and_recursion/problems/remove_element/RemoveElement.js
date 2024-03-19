let numbers = [3, 2, 2, 3];
let value = 3;

const removeElement = (nums, val) => {
  let i = 0;
  for (let j = 0; j < nums.length; j++) {
    if (nums[j] !== val) {
      nums[i] = nums[j];
      i++;
    }
  }
  return i;
};

let numsNotEqualToVal = removeElement(numbers, value);
console.log("numsNotEqualToVal :=>", numsNotEqualToVal);
// numsNotEqualToVal :=> 2

numbers = [0, 1, 2, 2, 3, 0, 4, 2];
value = 2;
numsNotEqualToVal = removeElement(numbers, value);
console.log("numsNotEqualToVal :=>", numsNotEqualToVal);
// numsNotEqualToVal: => 5
