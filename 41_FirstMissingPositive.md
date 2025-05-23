# [Leetcode 41: First Missing Positive](https://leetcode.com/problems/first-missing-positive/description/) [Array] [Hard]

## Problem Statement:
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and **uses O(1) auxiliary space**.

**Example 1:**

_Input_: nums = [1,2,0]

_Output_: 3

_Explanation_: The numbers in the range [1,2] are all in the array.

**Example 2:**

_Input_: nums = [3,4,-1,1]

_Output_: 2

_Explanation_: 1 is in the array but 2 is missing.

**Example 3:**

_Input_: nums = [7,8,9,11,12]

_Output_: 1

_Explanation_: The smallest positive integer 1 is missing.

## Solution
First mark the presence of numbers using their corresponding indices, then find the first index that isn’t marked — which gives the missing number.

✅ Step 1: Ignore invalid numbers
If a number is less than 1 or greater than n, replace it with a dummy value (like n + 100).

✅ Step 2: Mark the numbers that are present in the array
If a number like 3 is present, mark index 2 (which is 3 - 1) as negative.
This tells “3 is present in the array”

✅ Step 3: Find the first number that’s missing
The first index with a positive value means the number (index + 1) is missing.

If everything is marked (all negative), it means all numbers from 1 to n are there, so the answer is n + 1.

**Example:**
Input: [0, 3, 3, 4, -1, 1, 10]
→ After cleanup → [107, 3, 3, 4, 107, 1, 107]
→ After marking existing numbers → [-107, 3, -3, -4, 107, 1, 107]
→ First positive is at index 1 → Answer: 2

### Time Complexity:
**O(n)** - array is parsed thrice at linear time

### Space Complexity:
**O(1)** - No additional datastructures is created

```java
public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    int invalidValue = n + 100;

    //Mark invalid values that are out of the desired range (1 to n) with a placeholder
    for(int i = 0; i < n; i++) {
        if(nums[i] < 1 || nums[i] > n+1) {
            nums[i] = invalidValue;
        }
    }

    //Use index positions to mark the presence of values (mark negative)
    for(int i = 0; i < n; i++) {
        int val = Math.abs(nums[i]);
        if(val > 0 && val < n+1) {
            int indexToMark = val - 1;
            nums[indexToMark] = -1 * Math.abs(nums[indexToMark]);
        }
    }

    //The first index that isn't marked (still positive) is the missing number
    for(int i = 0; i < n; i++){
        if(nums[i] >= 0) {
            return i + 1;
        }
    }

    // If all positions are marked, the missing number is arrayLength + 1
    return n + 1;
}
```

