let string = "racecars";

const firstNonRepeatingCharacter = (str = "") => {
  const map = {};
  const chars = str.split("");
  // populate array with object, where keys
  // are unique characters, setting their count to 0
  for (let i = 0; i < chars.length; i++) {
    if (!map[chars[i]]) {
      map[chars[i]] = 0;
    }
  }
  // iterate again through them all and
  // simply add one for every occurence of each character
  for (let i = 0; i < chars.length; i++) {
    map[chars[i]]++;
  }
  // lastly look for the first instance of a
  // character that is not repeated and return the index
  for (let i = 0; i < chars.length; i++) {
    if (map[chars[i]] === 1) {
      return i;
    }
  }
  return -1;
};

let indexOfFirstNonRepeatingCharacter = firstNonRepeatingCharacter(string);
console.log(
  "indexOfFirstNonRepeatingCharacter :=>",
  indexOfFirstNonRepeatingCharacter,
);
// indexOfFirstNonRepeatingCharacter :=> 3

string = "abab";
indexOfFirstNonRepeatingCharacter = firstNonRepeatingCharacter(string);
console.log(
  "indexOfFirstNonRepeatingCharacter :=>",
  indexOfFirstNonRepeatingCharacter,
);
// indexOfFirstNonRepeatingCharacter :=> -1
