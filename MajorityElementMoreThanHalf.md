# [Leetcode 169: Majority Element](https://leetcode.com/problems/majority-element/) [Easy]

## Problem Statement:
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

**Example 1:**

Input: nums = [3,2,3]

Output: 3


**Example 2:**

Input: nums = [2,2,1,1,1,2,2]

Output: 2

## Solution
### Boyer-Moore Voting Algorithm
1. Keep a candidate and a count.
2. When you see the candidate, increase count.
3. When you see a different number, decrease count.
4. If count hits zero, pick the next number as candidate.

**The majority element can’t be canceled out completely, so it remains at the end.**
```java
class MajorityElementMoreThanHalf {
    public int majorityElement(int[] nums) {
        int majorityElement = nums[0];
        int count = 0;
        for(int num: nums) {
            if(num == majorityElement) {
                count++;
            } else {
                if(count == 0) {
                    majorityElement = num;
                    count++;
                } else {
                    count--;
                }
            }
        }
        return majorityElement;
    }
}
```

### Time Complexity: 
**O(n)** - array is parsed only once

### Space Complexity:
**O(1)** - keeps track of a few variables (like candidate(s) and counters), regardless of the input size, it uses constant space

