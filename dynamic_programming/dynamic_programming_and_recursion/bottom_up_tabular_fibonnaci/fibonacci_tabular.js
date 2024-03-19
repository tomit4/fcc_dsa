// much more efficient
// time complexity, as well as space complexity is O(n)
const fib = (n) => {
  const table = Array(n).fill(undefined);
  table[0] = 0;
  table[1] = 1;
  for (let i = 2; i <= n; i++) {
    table[i] = table[i - 1] + table[i - 2];
  }
  return table[n];
};

// obviously much faster, this is pretty much instantaneous
console.log("newFib :=>", fib(1000));
// newFib :=> 4.346655768693743e+208
