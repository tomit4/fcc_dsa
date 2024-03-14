const array = [5, 1, 10, 2, 9];

const sort = (arr = []) => {
  for (let i = 0; i < arr.length - 1; i++) {
    let indexOfMinimumValue = i;
    for (let j = i + 1; j < arr.length; j++) {
      if (arr[j] < arr[indexOfMinimumValue]) {
        indexOfMinimumValue = j;
      }
    }
    const temp = arr[indexOfMinimumValue];
    arr[indexOfMinimumValue] = arr[i];
    arr[i] = temp;
  }
  return arr;
};

console.log("sort(array) :=>", sort(array));
// sort(array) :=> [ 1, 2, 5, 9, 10 ]
