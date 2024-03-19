## Dynamic Programming

- Dynamic Programming is mainly an optimization over <em>recursion</em>.
- <em>Dynamic Programming = Recursion + Memorization</em> (i think he means
  memoization)

## Optimal Substructure

- A given problem has The Optimal Substructure Property if the optimal solution
  of the given probem can be obtained by using the optimal solution of its
  sub-problems.

- Example (see fibonacci_basic.js):

```
fib(n) = fib(n - 1) + fib(n - 2)
```

## Overlapping Subproblems

- A give problem has The Overlapping Subproblems Property if the solution of the
  given problem is obtained by solving the same subproblems multiple times.
  (see same example as above...???)

## Bottom Up Approach (see ./bottom_up_tabular_fibonnaci/fibonacci_tabular.js)

- Using the Bottom Up Approach, we attempt to solve smaller sub-problems first,
  using their solutions to build upon and arrive at solutions to bigger sub-problems.
- This is also known as the Tabulation method.
- The solution is built in a tabular form, by using solutions of smaller
  sub-problems iteratively and generating solutions to bigger sub-problems.

## Top Down Approach

- The Top Down Approach, like the Bottom Up Approach, uses a technique known as
  <em>Memoization</em>.
- Like the Bottom Up Approach, the Top Down Approach breaks down a large problem
  into multiple sub-problems.
- Each of the sub-problems are solved and the solutions are 'remembered'.
- If the sub-problem is solved already, reuse the answer.
- Else, solve the sub-problem and store the result.
- Thus, the Top Down Approach 'memorizes' the solution of the sub-problem to
  avoid recomputing the value if the sub-problem is encountered again.
