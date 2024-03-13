const array = [5, 1, 9, 2, 10];

const bubbleSort = (arr) => {
  for (let i = 0; i < arr.length - 1; i++) {
    let swapHasOccurred = false;
    for (let j = 0; j < arr.length - 1 - i; j++) {
      if (arr[j] > arr[j + 1]) {
        const temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
        swapHasOccurred = true;
      }
    }
    if (swapHasOccurred === false) break;
  }
  return arr;
};

console.log("bubbleSort(array) :=>", bubbleSort(array));
// bubbleSort(array) :=> [ 1, 2, 5, 9, 10 ]
