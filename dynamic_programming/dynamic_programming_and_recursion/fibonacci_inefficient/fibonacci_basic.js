// inefficient solution, as the time complexity is O(2^n), while the space complexity is O(n).
const fib = (n) => {
  if (n === 0) return 0;
  if (n === 1) return 1;
  const left = fib(n - 1);
  const right = fib(n - 2);
  return left + right;
};

// starts to get slow, even with our beefy computer, going higher is very slow
console.log("fib(40) :=>", fib(40));
