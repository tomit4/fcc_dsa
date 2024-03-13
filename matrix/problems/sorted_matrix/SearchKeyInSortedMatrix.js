const matrix = [
  [ 10, 20, 30, 40 ],
  [ 15, 25, 35, 45 ],
  [ 27, 29, 37, 48 ],
  [ 32, 33, 39, 51 ],
];

// matrix represents a 2D array of sorted elements (a sorted matrix)
// n is the number of columns
// x is the element to search
const search = (matrix = [ [] ], n, x) => {
  // i is the index row index of where we start (the first row)
  let i = 0;
  // j is the column index where we start (the last element of each row)
  let j = n - 1;
  while (i < n && j >= 0) {
    if (matrix[i][j] === x) {
      console.log(`x found at row :=> ${i}, and column :=> ${j}`);
      return true;
      // since the array is sorted, the element either resides
      // within this row, and we can simply iterate backwards through
      // each row array until we reach an element that is greater
      // than the one we search for, then..
    } else if (matrix[i][j] > x) {
      j--;
      // we go one row down! this means that we don't have to traverse
      // each element, we "skip" down to the next row if we arrive at
      // any element lesser than the one we are searching for
      // Essentially, because the matrix is sorted, we are able to
      // traverse the matrix DIAGONALLY
    } else {
      i++;
    }
  }
  console.log("x not found :=>");
};

search(matrix, 4, 32);
/ x found at row :=> 3, and column :=> 0
