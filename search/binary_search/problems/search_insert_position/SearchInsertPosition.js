const array = [1, 3, 5, 7];

const binarySearch = (nums = [], key) => {
  let low = 0;
  let high = nums.length - 1;
  let output = undefined;

  while (low <= high) {
    let mid = Math.floor((high + low) / 2);
    if (nums[mid] === key) {
      output = mid;
    } else if (key < nums[mid]) {
      high = mid - 1;
    } else {
      low = mid + 1;
    }
  }
  if (output === undefined) {
    output = low;
  }
  return output;
};

console.log("binarySearch(array, 5) :=>", binarySearch(array, 5));
console.log("binarySearch(array, 2) :=>", binarySearch(array, 2));
console.log("binarySearch(array, 8) :=>", binarySearch(array, 8));
console.log("binarySearch(array, 0) :=>", binarySearch(array, 0));
// binarySearch(array, 5) :=> 2
// binarySearch(array, 2) :=> 1
// binarySearch(array, 8) :=> 4
// binarySearch(array, 0) :=> 0
