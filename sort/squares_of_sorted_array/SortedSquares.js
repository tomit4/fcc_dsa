const array = [-4, -1, 0, 3, 10];

const sortedSquares = (arr = []) => {
  const result = [];
  let i = 0;
  let j = arr.length - 1;
  for (let k = arr.length - 1; k >= 0; k--) {
    if (Math.abs(arr[i]) > Math.abs(arr[j])) {
      result[k] = arr[i] ** 2;
      i++;
    } else {
      result[k] = arr[j] ** 2;
      j--;
    }
  }
  return result;
};

const sortedSquareArray = sortedSquares(array);
console.log("sortedSquareArray :=>", sortedSquareArray);
// sortedSquareArray :=> [ 0, 1, 9, 16, 100 ]
