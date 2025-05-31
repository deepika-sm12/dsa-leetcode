# [Leetcode 2894: Divisible and Non-divisible Sums Difference](https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/description/) [Math] [Easy]

## Problem Statement:
You are given positive integers n and m.

Define two integers as follows:
* num1: The sum of all integers in the range [1, n] (both inclusive) that are not divisible by m.
* num2: The sum of all integers in the range [1, n] (both inclusive) that are divisible by m.


Return the integer `num1 - num2`.

**Example 1:**

_Input_: n = 10, m = 3

_Output_: 19

_Explanation_: In the given example:
- Integers in the range [1, 10] that are not divisible by 3 are [1,2,4,5,7,8,10], num1 is the sum of those integers = 37.
- Integers in the range [1, 10] that are divisible by 3 are [3,6,9], num2 is the sum of those integers = 18. 

We return 37 - 18 = 19 as the answer.

**Example 2:**

_Input_: n = 5, m = 6

_Output_: 15

_Explanation_: In the given example:
- Integers in the range [1, 5] that are not divisible by 6 are [1,2,3,4,5], num1 is the sum of those integers = 15.
- Integers in the range [1, 5] that are divisible by 6 are [], num2 is the sum of those integers = 0.

We return 15 - 0 = 15 as the answer.

**Example 3:**

_Input_: n = 5, m = 1

_Output_: -15

_Explanation_: In the given example:
- Integers in the range [1, 5] that are not divisible by 1 are [], num1 is the sum of those integers = 0.
- Integers in the range [1, 5] that are divisible by 1 are [1,2,3,4,5], num2 is the sum of those integers = 15.
  
We return 0 - 15 = -15 as the answer.

## Solution (using summation formula - arithmetic series formula)
Avoid looping through all numbers from 1 to n. Instead, use the formula for the sum of the first k natural numbers:
`sum(k) = k * (k + 1) / 2`

Also, calculate the number of integers divisible by m up to n, and use it to find their sum using the same formula scaled by m.

### 🧠 Core Idea:
* Total `sum from 1 to n = sum(n)`
* Numbers divisible by m are: m, 2m, 3m, ..., k*m where k = n / m
* Their sum = `m * sum(k)`
* Non-divisible sum = `sum(n) - sum(divisible)`
* Return the difference: `(non-divisible sum - divisible sum)`

### Time Complexity:
**O(1)** - constant time for arithmetic operations

### Space Complexity:
**O(1)** - no additional data structures used

```java
public int differenceOfSums(int n, int m) {
    int divisibleNumbersCnt = n / m;

    int num2 = m * sum(divisibleNumbersCnt);
    int num1 = sum(n) - num2;

    return num1 - num2;
}

private int sum(int n) {
    return (n * (n + 1)) / 2;
}
```
