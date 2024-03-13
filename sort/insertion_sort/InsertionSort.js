const array = [5, 1, 9, 2, 10];

const insertionSort = (arr) => {
  // starting at the second element of the array, arr[1]
  for (let i = 1; i < arr.length; i++) {
    const temp = arr[i];
    // j initialized at 0, and always
    // points to an element previous to arr[i]
    let j = i - 1;
    // traverses backwards, continually swapping
    // until arr[i] is greater than arr[j]
    while (j >= 0 && arr[j] > temp) {
      // note we do not use i here as we need
      // to keep looking back through the array until
      // the greater than condition above returns false
      arr[j + 1] = arr[j];
      j = j - 1;
    }
    arr[j + 1] = temp;
  }
  return arr;
};

console.log("insertionSort(array) :=>", insertionSort(array));
