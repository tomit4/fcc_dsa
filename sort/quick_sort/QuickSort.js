const array = [5, 2, 0, 1, 6, 3];

const partition = (arr = [], low, high) => {
  // pivot is used at the end here,
  // but the original high value
  // (called at the end of this file), can be any index
  const pivot = arr[high];
  let i = low;
  let j = low;
  while (i <= high) {
    if (arr[i] <= pivot) {
      const temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      j++;
    }
    i++;
  }
  return j - 1;
};

const quickSort = (arr = [], low, high) => {
  if (low < high) {
    const p = partition(arr, low, high);
    quickSort(arr, low, p - 1);
    quickSort(arr, p + 1, high);
  }
};

quickSort(array, 0, array.length - 1);
console.log("array :=>", array);
// array :=> [ 0, 1, 2, 3, 5, 6 ]
