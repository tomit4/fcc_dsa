// NOTE: Tutorial doesn't provide proper context for
// establishing this in java and I'm lazy, so here it is in JS:

/*
 * A somewhat complicated algorithm for a beginner.
 * Here we traverse our original array backwards,
 * pushing the first number to be higher than the number at arr[i]
 * onto the stack.
 * If, however, the latest addition to the stack (the top)
 * is less than the inspected number at arr[i], the value is popped off the
 * stack and the while loop continues.
 *
 * Once that terminates, the stack is checked to see if it is empty,
 * if it is, then the result[i] is stored a value of -1,
 * otherwise, the top element of the stack is assigned to result[i].
 *
 * Finally the latest element of the array is pushed onto the
 * stack to be compared again in the while loop above. This is done until
 * all elements are traversed backwards through the original arr
 * */

// initial array = [4, 7, 3, 4, 8, 1]
const nextGreaterElement = (arr = []) => {
  const result = [];
  const stack = [];
  for (let i = arr.length - 1; i >= 0; i--) {
    if (stack.length > 0) {
      while (stack.length > 0 && stack[stack.length - 1] <= arr[i]) {
        stack.pop();
      }
    }
    if (!stack.length) {
      result[i] = -1;
    } else {
      result[i] = stack[stack.length - 1];
    }
    stack.push(arr[i]);
  }
  return result;
};

const resultArr = nextGreaterElement([4, 7, 3, 4, 8, 1]);

console.log("resultArr :=>", resultArr);
// resultArr :=> [ 7, 8, 4, 8, -1, -1 ]
