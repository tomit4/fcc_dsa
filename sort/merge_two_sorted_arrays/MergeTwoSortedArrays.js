const array1 = [2, 5, 7];
const array2 = [3, 4, 9, 10];

const merge = (arr1 = [], arr2 = []) => {
  // const result = new Array<number>(arr1.length + arr2.length); TS style
  const result = [];
  let i = 0; // counter for arr1
  let j = 0; // counter for arr2
  let k = 0; // counter for result
  // The reason we can't just push is because one
  // of our indexes, i or j could go outside the
  // bounds of th e other array to be merged

  while (i < arr1.length && j < arr2.length) {
    if (arr1[i] < arr2[j]) {
      result[k] = arr1[i];
      i++;
    } else {
      result[k] = arr2[j];
      j++;
    }
    k++;
  }
  // console.log("result :=>", result); // [2, 3, 4, 5, 7]

  // Since one of our array index pointers (i or j)
  // could break out of the previous while loop before
  // the other one would have traversed its own respective initial array...

  // We then follow up with two while loops that simply traverse both our
  // initial arrays and also our result array. Since both arrays are
  // sorted, they will simply populate the result array properly

  // in this situation, i is NOT less than arr1.length,
  // as it has been incremented to = arr1.length
  while (i < arr1.length) {
    result[k] = arr1[i];
    i++;
    k++;
  }
  // in this situation, j IS less than arr2.length, as the
  // above while loop broke out before all elements of arr2
  // could be traversed, thusly this while loop executes
  while (j < arr2.length) {
    result[k] = arr2[j];
    j++;
    k++;
  }
  return result;
};

const array3 = merge(array1, array2);
console.log("array3 :=>", array3);
// array3 :=> [ 2, 3, 4, 5, 7, 9, 10 ]
