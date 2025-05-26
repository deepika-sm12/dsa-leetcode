# [Leetcode 338. Counting Bits](https://leetcode.com/problems/counting-bits/description/) [Bit] [Easy]

## Problem Statement:
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

**Example 1:**

_Input_: n = 2

_Output_: [0,1,1]

_Explanation_:
```
For 0, Binary representation - 0, noOfOnes = 0
For 1, Binary representation - 1, noOfOnes = 1
For 2, Binary representation - 10, noOfOnes = 1 
```

**Example 2:**

_Input_: n = 5

_Output_: [0,1,1,2,1,2]

_Explanation_:
```
For 0, Binary representation -0, noOfOnes = 0
For 1, Binary representation -1, noOfOnes = 1
For 2, Binary representation -10, noOfOnes = 1
For 3, Binary representation -11, noOfOnes = 2
For 4, Binary representation -100, noOfOnes = 1
For 5, Binary representation -101, noOfOnes = 2
```

## Solution (Naive)
Count the number of 1s by repeatedly checking the last binary digit (using remainder 2) and removing it (dividing by 2) until the number becomes zero.

✅ Step 1: Extract the least significant bit (LSB) using n % 2
* n % 2 gives the remainder when dividing by 2.
* In binary terms, this corresponds exactly to the LSB (rightmost bit).
* If n % 2 == 1, the LSB is set → increment your count by 1.
* If n % 2 == 0, the LSB is 0 → no increment.

✅ Step 2: Remove the least significant bit (LSB) by dividing by 2 (n / 2)
* Integer division by 2 shifts the bits of n to the right by one position.
* This means the LSB is removed, and the second least significant bit becomes the new LSB.
    ```
  For example:
    13 (binary 1101)
    13 / 2 = 6 (binary 0110)
  ```
* Now repeat Step 1 on this smaller number to extract the next bit.

✅ Step 3: Repeat until n becomes 0
* When n becomes 0, it means all bits have been processed.
* The accumulated count is the number of 1s in the binary representation of the original number.

### Time Complexity:
**O(n * log n)** - 
* For each number from 0 to n, counting the number of 1s takes O(log i) time (since dividing by 2 reduces the number of bits).
* Summed over all numbers: O(log 1 + log 2 + ... + log n) = O(n log n)

### Space Complexity:
**O(n)** - output array

```java
public static int[] countBits(int n) {
    int[] ans = new int[n + 1];
    int count = 0;
    int num;

    for(int i = 0; i <= n; i++) {
        count = 0;
        num = i;
        while(num > 0) {
            count += num % 2;
            num = num / 2;
        }
        ans[i] = count;
    }

    return ans;
}
```

## Solution (Using Dynamic Programming to reduce time complexity)
Dividing i by 2 (i / 2) removes the last bit (rightmost bit).
So, 
`Number of 1s in i = Number of 1s in (i / 2) plus 1 if i is odd else 0.`

This reuses results from smaller numbers that have already been computed — which is the essence of dynamic programming.

### Time Complexity:
**O(n)** - The loop runs from 1 to n, and each operation inside the loop takes constant time.

### Space Complexity:
**O(n)** - output array

```java
public int[] countBits(int n) {
    int[] ans = new int[n + 1];
    ans[0] = 0;

    for(int i = 1; i<=n; i++) {
        ans[i] = ans[i / 2] + (i % 2);
    }

    return ans;
}
```