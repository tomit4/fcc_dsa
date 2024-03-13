const matrix = [
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9, 10, 11, 12],
  [13, 14, 15, 16],
  [17, 18, 19, 20],
];

const spiralPrint = (matrix = [[]], rows, columns) => {
  let i = 0;
  let k = 0;
  let l = 0;
  while (k < rows && l < columns) {
    for (i = l; i < columns; i++) {
      console.log(`${matrix[k][i]} `);
    }
    k++;
    for (i = k; i < rows; i++) {
      console.log(`${matrix[i][columns - 1]} `);
    }
    columns--;
    if (k < rows) {
      for (i = columns - 1; i >= l; i--) {
        console.log(`${matrix[rows - 1][i]} `);
      }
      rows--;
    }
    if (l < columns) {
      for (i = rows - 1; i >= k; i--) {
        console.log(`${matrix[i][l]} `);
      }
      l++;
    }
  }
};

spiralPrint(matrix, matrix.length, matrix[0].length);
