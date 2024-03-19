let num = -1234;

const reverse = (number) => {
  const isNegative = number < 0;
  if (isNegative) {
    number = number * -1;
  }
  let reverse = 0;
  let lastDigit = undefined;
  while (number > 0) {
    lastDigit = number % 10;
    reverse = reverse * 10 + lastDigit;
    number = Math.floor(number / 10);
  }
  return isNegative ? reverse * -1 : reverse;
};

let reversedNum = reverse(num);
console.log("reversedNum :=>", reversedNum);
// reversedNum :=> -4321

num = 2147483647;
reversedNum = reverse(num);
console.log("reversedNum :=>", reversedNum);
// reversedNum :=> 7463847412
