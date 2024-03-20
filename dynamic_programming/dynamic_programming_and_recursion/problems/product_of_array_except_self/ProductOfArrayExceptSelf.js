let array = [1, 2, 3, 4];

const productOfArrayExceptSelf = (arr = []) => {
  let temp = 1;
  const result = [];
  for (let i = 0; i < arr.length; i++) {
    result[i] = temp;
    // store the product of the left side elements of the arr
    temp = temp * arr[i];
  }
  temp = 1;
  // the rightmost element(last) is correct, but the rest need to traverse backwards
  // and calculate the product of the right side and left side.
  // i.e. temp holds onto the total product of remaining elements,
  // while we traverse backards, reassigning result[i] one by one with the result[i] * temp...
  for (let i = arr.length - 1; i >= 0; i--) {
    result[i] = result[i] * temp;
    temp = temp * arr[i];
  }
  return result;
};

let products = productOfArrayExceptSelf(array);
console.log("products :=>", products);
// products :=> [ 24, 12, 8, 6 ]

array = [-1, 1, 0, -3, 3];
products = productOfArrayExceptSelf(array);
console.log("products :=>", products);
// products :=> [ -0, 0, 9, -0, 0 ]
