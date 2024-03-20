// Example -
// Input: str = "abcabcbb"
// Ouput: 3
let str = "abcabcbb";

const lengthOfLongestSubString = (s = "") => {
  const map = {};
  let maxLength = 0;
  let start = 0;
  for (let end = 0; end < s.length; end++) {
    const rightChar = s.charAt(end);
    if (map[rightChar]) {
      start = Math.max(start, map[rightChar] + 1);
    }
    map[rightChar] = end;
    maxLength = Math.max(maxLength, end - start + 1);
  }
  return maxLength;
};

let longestSubStrLen = lengthOfLongestSubString(str);
console.log("longestSubStrLen :=>", longestSubStrLen);
// 4, wrong

str = "bbbb";
longestSubStrLen = lengthOfLongestSubString(str);
console.log("longestSubStrLen :=>", longestSubStrLen);
// 1 right

str = "pwwkew";
longestSubStrLen = lengthOfLongestSubString(str);
console.log("longestSubStrLen :=>", longestSubStrLen);
// 3 right
