// NOTE: though this matrix is sorted, this algorithm doesn't require it to be
const matrix = [
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9, 10, 11, 12],
  [13, 14, 15, 16],
  [17, 18, 19, 20],
];

// to be absolutely clear, rows is AMOUNT of rows, and columns is AMOUNT of columns
const spiralPrint = (matrix = [[]], rows, columns) => {
  let i = 0;
  // start two pointers, one for rows, k, and one for columns, l
  let k = 0;
  let l = 0;
  while (k < rows && l < columns) {
    // print across the row (left to right)
    for (i = l; i < columns; i++) {
      console.log(`${matrix[k][i]} `);
    }
    // point k to the next row (pointing to the next inner row)
    k++;
    // print across the column (top to bottom)
    for (i = k; i < rows; i++) {
      console.log(`${matrix[i][columns - 1]} `);
    }
    // decrement columns by one
    // (use it as a pointer so we don't traverse that column  on the next loop through)
    columns--;
    // as long as there are still rows to go across..., and it hasn't gone over row count
    // (which would cause it to traverse elements that our algorithm has already traversed)
    if (k < rows) {
      // print across the row (right to left)
      for (i = columns - 1; i >= l; i--) {
        console.log(`${matrix[rows - 1][i]} `);
      }
      // decrement rows by one
      // (use it as a pointer so we don't traverse that row on the next loop through)
      rows--;
    }
    // as long as there are still columns to go across, and it hasn't gone over columns count
    // (which would cause it to traverse elements that our algorithm has already traversed)
    if (l < columns) {
      // print across the column (bottom to top)
      for (i = rows - 1; i >= k; i--) {
        console.log(`${matrix[i][l]} `);
      }
      // increase the pointer column by one (pointing to the next inner column)
      l++;
    }
  }
};

spiralPrint(matrix, matrix.length, matrix[0].length);
