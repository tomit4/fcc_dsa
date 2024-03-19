// both time and space complexity are O(n),
// because we store the return value in memo,
// we can ensure we only ever calculate each fibonacci number each ONCE
// as opposed to our initial, least optimized solution (see ../fibonacci_inefficient/fibonacci_basic.js),
// which while similar looking, the use of memo[]
// and our initial checks prevent us from recalculating previous fibonacci numbers
const fib = (memo = [], n) => {
  memo = memo.length ? memo : Array(n + 1).fill(0);
  if (memo[n] === 0) {
    if (n < 2) {
      memo[n] = n;
    } else {
      const left = fib(memo, n - 1);
      const right = fib(memo, n - 2);
      memo[n] = left + right;
    }
  }
  return memo[n];
};

// just as fast as our bottom down solution (O(n))
console.log("newFib :=>", fib([], 1000));
// newFib :=> 4.346655768693743e+208
