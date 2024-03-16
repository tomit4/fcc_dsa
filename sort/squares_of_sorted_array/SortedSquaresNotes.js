const array = [-4, -1, 0, 3, 10];

const sortedSquares = (arr = []) => {
  const result = [];
  // Three pointers (i, j, k),
  // i starts at the beginning of the array,
  // j and k start at the end
  let i = 0;
  let j = arr.length - 1;
  for (let k = arr.length - 1; k >= 0; k--) {
    if (Math.abs(arr[i]) > Math.abs(arr[j])) {
      // if the element towards beginning of array(i) is greater than element at end of array(j)
      // assign that element (squared) to the result array at the towards the end index, k
      result[k] = arr[i] ** 2;
      // and increment the i pointer further towards the center of the array
      i++;
    } else {
      // otherwise the towards the end of array element(j)
      // is greater than the element towards the beginning of array(i)
      // and we assign that element (squared) to the result array at the towards the end index, k
      result[k] = arr[j] ** 2;
      // and decrement the j pointer further towards the center of the array
      j--;
    }
  }
  return result;
};

const sortedSquareArray = sortedSquares(array);
console.log("sortedSquareArray :=>", sortedSquareArray);
// sortedSquareArray :=> [ 0, 1, 9, 16, 100 ]
