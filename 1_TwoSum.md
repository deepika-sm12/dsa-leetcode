# [Leetcode 1: Two Sum](https://leetcode.com/problems/two-sum/description/) [Array] [Easy]

## Problem Statement:
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have **exactly one solution**, and you may not use the same element twice.

You can return the answer in any order.

Can you come up with an algorithm that is **less than O(n2) time complexity**?

**Example 1:**

_Input_: nums = [2,7,11,15], target = 9

_Output_: [0,1]

_Explanation_: Because nums[0] + nums[1] == 9, we return [0, 1].

**Example 2:**

_Input_: nums = [3,2,4], target = 6

_Output_: [0,1]

## Solution using HashMap (Single Pass)
Instead of checking every possible pair (which is O(n * n)), use a map to store numbers seen so far. For each number, check if the complement (target - current number) is already in the map.

### Time Complexity:
**O(n)** - array length

### Space Complexity:
**O(n)** - HashMap to store the values and their indices

```java
public int[] twoSum(int[] nums, int target) {
  Map<Integer, Integer> idxMap = new HashMap<>();

  for(int i = 0; i < nums.length; i++) {
    int num2 = target - nums[i];
    if(idxMap.containsKey(num2)) {
      return new int[]{i, idxMap.get(num2)};
    }
    idxMap.put(nums[i], i);
  }

  return null;
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