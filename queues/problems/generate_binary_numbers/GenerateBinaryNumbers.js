// returns a String[]
const generateBinaryNumbers = (n = 0) => {
  const result = [];
  const queue = {
    elements: [],
    offer: function (item) {
      this.elements.push(item);
    },
    poll: function () {
      return this.elements.shift();
    },
  };
  queue.offer("1");
  for (let i = 0; i < n; i++) {
    result[i] = queue.poll();
    const n1 = result[i] + "0";
    const n2 = result[i] + "1";
    queue.offer(n1);
    queue.offer(n2);
  }
  return result; // [1, 10, 11, 100]
};

console.log("generateBinaryNumbers(3) :=>", generateBinaryNumbers(3));
// generateBinaryNumbers(3) :=> [ '1', '10', '11' ]
console.log("generateBinaryNumbers(4) :=>", generateBinaryNumbers(4));
// generateBinaryNumbers(4) :=> [ '1', '10', '11', '100' ]
console.log("generateBinaryNumbers(5) :=>", generateBinaryNumbers(5));
// generateBinaryNumbers(5) :=> [ '1', '10', '11', '100', '101' ]
