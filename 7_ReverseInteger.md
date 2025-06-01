# [Leetcode 7: Reverse Integer](https://leetcode.com/problems/reverse-integer/description/) [Math] [Medium]

## Problem Statement:
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

**Note: Assume the environment does not allow you to store 64-bit integers (signed or unsigned).**

**Example 1:**

_Input_: x = 123

_Output_: 321

**Example 2:**

_Input_: x = -123

_Output_: -321

**Example 3:**

_Input_: x = 120

_Output_: 21

## Solution
The reversal process involves extracting each digit from the original number one by one and appending it to the reversed number.

### 🧠 Core Idea:
* Extract digits by taking the remainder of division by 10 (pop = x % 10).
* Check for potential overflow before appending the next digit. Since the reversed number must fit within the signed 32-bit integer range (-2^31 to 2^31 - 1), it is necessary to verify that multiplying by 10 and adding the next digit does not exceed these limits.
* Build the reversed number by multiplying the current reversed number by 10 and adding the extracted digit (reversed = reversed * 10 + pop).
* Leading zeros in the reversed number naturally disappear because of the way digits are appended.

### Time Complexity:
**O(d)** - d = number of digits in the number

### Space Complexity:
**O(1)** - No additional data structures is created

```java
public int reverse(int x) {
    int reversed = 0;

    while(x != 0) {
        if(reversed > Integer.MAX_VALUE / 10 || reversed < Integer.MIN_VALUE / 10) {
            return 0;
        }

        int numToSwitch = x % 10;

        if(reversed == (Integer.MAX_VALUE / 10) && numToSwitch > 7) {
            return 0;
        }
        if(reversed == (Integer.MIN_VALUE / 10) && numToSwitch < -1) {
            return 0;
        }

        reversed = reversed * 10 + numToSwitch;
        x = x/10;
    }

    return reversed;
}
```