const array = [9, 5, 2, 4, 3];

const merge = (arr = [], temp = [], low, mid, high) => {
  for (let i = low; i <= high; i++) {
    temp[i] = arr[i];
  }
  let i = low;
  let j = mid + 1;
  let k = low;
  while (i <= mid && j <= high) {
    if (temp[i] <= temp[j]) {
      arr[k] = temp[i];
      i++;
    } else {
      arr[k] = temp[j];
      j++;
    }
    k++;
  }
  while (i <= mid) {
    arr[k] = temp[i];
    i++;
    k++;
  }
  return arr;
};

const sort = (arr = [], temp = [], low, high) => {
  if (low < high) {
    const mid = low + (high - low) / 2;
    sort(arr, temp, low, mid);
    sort(arr, temp, mid + 1, high);
    merge(arr, temp, low, mid, high);
  }
  return arr;
};

console.log(
  "sort(array, [], 0, arr.length - 1) :=>",
  sort(array, [], 0, array.length - 1),
);
// sort(array, [], 0, arr.length - 1) :=> [ 2, 4, 3, 9, 5 ]
