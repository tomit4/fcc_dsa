let integer = 1234;

const reverseAnInteger = (int) => {
  const intIsNegative = int < 0;
  if (intIsNegative) {
    int = Math.abs(int);
  }
  // one way of doing it, but calling it dirty because it doesn't involve true math
  let returnNum = Number(String(int).split("").reverse().join(""));
  if (intIsNegative) {
    returnNum = -Math.abs(returnNum);
  }
  return returnNum;
};

let reversedInt = reverseAnInteger(integer);
console.log("reversedInt :=>", reversedInt);
// reversedInt :=> 4321

integer = -4321;
reversedInt = reverseAnInteger(integer);
console.log("reversedInt :=>", reversedInt);
// reversedInt :=> -1234

integer = 2147483647;
reversedInt = reverseAnInteger(integer);
console.log("reversedInt :=>", reversedInt);
// reversedInt: => 7463847412
