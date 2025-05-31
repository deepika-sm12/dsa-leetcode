# [Leetcode 128: Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/description/) [Array] [Medium]

## Problem Statement:
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that **runs in O(n)** time.

**Example 1:**

_Input_: nums = [100,4,200,1,3,2]

_Output_: 4

_Explanation_: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

**Example 2:**

_Input_: nums = [0,3,7,2,5,8,4,6,0,1]

_Output_: 9

**Example 3:**

_Input_: nums = [1,0,1,2]

_Output_: 3

## Solution (Using a HashSet)
To find the longest consecutive sequence in an unsorted array in O(n) time, we need:
* Constant-time lookups ⇒ use a HashSet
* A way to ensure we only start counting from the beginning of a sequence (not from every number)

  ⤷ For example, if num = 100, we only start a sequence if 99 is not present.

### 🧠 Core Idea:
* Add all numbers to a set for O(1) lookup.
* Iterate over the set.
  * Only start counting when the current number is the start of a sequence (num - 1 not in set).
  * Then, keep incrementing num + 1, num + 2, … as long as the next number is in the set.
* Track the maximum length encountered.
This avoids duplicate counting and ensures each sequence is processed once.

### Time Complexity:
**O(n)** - Each number is checked at most once for the start of a sequence, and each sequence runs through unique elements

### Space Complexity:
**O(n)** - HashSet to store the unique elements

```java
public int longestConsecutive(int[] nums) {
    if(nums.length == 0 || nums.length == 1) {
        return nums.length;
    }

    Set<Integer> numSet = new HashSet<>();
    for(int num: nums) {
        numSet.add(num);
    }

    int maxLen = 1;
    for(Integer num: numSet) {
        if(!numSet.contains(num - 1)) { //Only start counting if it's the start of a sequence
            int seqLen = 1;
            while(numSet.contains(num + 1)) {
                seqLen++;
                num++;
            }
            maxLen = Math.max(seqLen, maxLen);
        }
    }

    return maxLen;
}
```