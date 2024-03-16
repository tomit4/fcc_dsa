const array = [2, 3, 5, 6, 8, 9];

const arrangeMaxMin = (arr = []) => {
  maxIdx = arr.length - 1;
  minIdx = 0;
  max = arr[maxIdx] + 1;
  for (let i = 0; i < arr.length; i++) {
    if (i % 2 === 0) {
      arr[i] = arr[i] + (arr[maxIdx] % max) * max;
      maxIdx--;
    } else {
      arr[i] = arr[i] + (arr[minIdx] % max) * max;
      minIdx++;
    }
  }
  for (let i = 0; i < arr.length; i++) {
    arr[i] = Math.floor(arr[i] / max);
  }
};

arrangeMaxMin(array);
console.log("array :=>", array);
// array :=> [ 9, 2, 8, 3, 6, 5 ]
