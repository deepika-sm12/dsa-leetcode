# [Leetcode 3550. Smallest Index With Digit Sum Equal to Index](https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/description/) [Array] [Easy]

## Problem Statement:
You are given an integer array nums.

Return the smallest index i such that the sum of the digits of nums[i] is equal to i.

If no such index exists, return -1.

**Example 1:**

_Input_: nums = [1,3,2]

_Output_: 2

_Explanation:_

For nums[2] = 2, the sum of digits is 2, which is equal to index i = 2. Thus, the output is 2.


**Example 2:**

_Input_: nums = [1,10,11]

_Output_: 1

_Explanation_:

* For nums[1] = 10, the sum of digits is 1 + 0 = 1, which is equal to index i = 1.
* For nums[2] = 11, the sum of digits is 1 + 1 = 2, which is equal to index i = 2.
* Since index 1 is the smallest, the output is 1.

**Example 3:**

_Input_: nums = [1,2,3]

_Output_: -1

_Explanation_:

* Since no index satisfies the condition, the output is -1.

## Solution
1. For each element, find the sum of the digits
2. Check if the sum of the digits is equal to the index of the element

### Time Complexity:
**O(n)** - array is parsed only once

### Space Complexity:
**O(1)** - No additional arrays/ds created

```java
public int smallestIndex(int[] nums) {
   for(int i = 0; i < nums.length; i++) {
      if(i == sumOfDigits(nums[i])) {
         return i;
      }
   }

   return -1;
}

private static int sumOfDigits(int num) {
   int sum = 0;
   while(num > 0) {
      sum += num % 10;
      num /= 10;
   }
   return sum;
}
```
