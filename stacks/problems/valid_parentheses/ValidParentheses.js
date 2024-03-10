/*
 * A more simple algorithm.
 * Here we simply split our string of parentheses characters into an array...
 * And iterate over them...
 * If we encounter an opening array character ("(", "{", "["), then we push it onto the stack
 * As long as the stack has a charcter in it,
 * we then check if the character is a closing parentheses character (")", "}", "]").
 * as well as if the most recent character pushed to the stack (the top), is the
 * corresponding opening parentheses character. If it is, we pop it off the stack.
 * At the end, we simply check the stack,
 * if there are still characters in the stack,
 * then we had non matching, invalid parentheses remaining
 * and the function returns false,
 * otherwise it returns true.
 * */

const validParens = (str = "") => {
  const stack = [];
  const strArr = str.split("");
  for (let i = 0; i < strArr.length; i++) {
    const c = strArr[i];
    if (c === "(" || c === "{" || c === "[") {
      stack.push(c);
    }
    if (stack.length) {
      const top = stack[stack.length - 1];
      if (
        (c === ")" && top === "(") ||
        (c === "}" && top === "{") ||
        (c === "]" && top === "[")
      ) {
        stack.pop();
      }
    }
  }
  return stack.length === 0;
};

console.log("isValid? {()} :=>", validParens("{()}")); // true
console.log("isValid? {] :=>", validParens("{]")); // false
console.log("isValid? {() :=>", validParens("{()")); // false
console.log("isValid? }{ :=>", validParens("}{")); // false
console.log("isValid? { :=>", validParens("{")); // false
