# [Leetcode 392: Is Subsequence](https://leetcode.com/problems/is-subsequence/description/) [String] [Easy]

## Problem Statement:
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

**Example 1:**

_Input_: s = "abc", t = "ahbgdc"

_Output_: true


**Example 2:**

_Input_: s = "axc", t = "ahbgdc"

_Output_: false

## Solution
The solution uses a **two-pointer strategy** to efficiently check if string s is a subsequence of string t.

✅ Step 1: Initialize two pointers:
* i for tracking the position in s
* j for tracking the position in t

✅ Step 2: Traverse both strings using a loop until one of them is completely parsed:
* At each step, compare the characters at s[i] and t[j]
* If they match, increment i — this means the current character of s has been found in t in the correct order.
* Always increment j — this ensures that the search in t continues forward, preserving the relative order.

### Time Complexity:
**O(n)** - t or s string is completely traversed

### Space Complexity:
**O(1)** - No additional datastructures is created

```java
public boolean isSubsequence(String s, String t) {
    int i = 0, j = 0;
    while(i < s.length() && j < t.length()) {
        if(s.charAt(i) == t.charAt(j)) {
            i++;
        }
        j++;
    }

    return i == s.length();
}
```

