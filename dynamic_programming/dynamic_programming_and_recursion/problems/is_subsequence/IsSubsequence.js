const string = "abcde";
let sequence = "ace";

// time complexity is O(n), where n is the number or characters in the "string" variable
const isSubsequence = (str = "", seq = "") => {
  if (str.length < seq.length) {
    console.error("ERROR string cannot have less characters than sequence:=>");
    return false;
  }
  let i = 0;
  let j = 0;
  while (i < str.length && j < seq.length) {
    if (str.charAt(i) === seq.charAt(j)) {
      j++;
    }
    i++;
  }
  return j === seq.length;
};

let sequenceIsSubsequenceOfString = isSubsequence(string, sequence);
console.log("sequenceIsSubsequenceOfString :=>", sequenceIsSubsequenceOfString);
// sequenceIsSubsequenceOfString :=> true

sequence = "aec";
sequenceIsSubsequenceOfString = isSubsequence(string, sequence);
console.log("sequenceIsSubsequenceOfString :=>", sequenceIsSubsequenceOfString);
// sequenceIsSubsequenceOfString :=> false
