const string = "ice cream";
const vowels = new Set(["a", "e", "i", "o", "u"]);

const removeVowelsFromString = (str = "") => {
  const char = str.split("");
  let returnStr = "";
  for (const ch of char) {
    if (!vowels.has(ch)) {
      returnStr = `${returnStr}${ch}`;
    }
  }
  return returnStr;
};

const stringWithoutVowels = removeVowelsFromString(string);
console.log("stringWithoutVowels :=>", stringWithoutVowels);
// stringWithoutVowels :=> c crm
