# [151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/description/) [String] [Medium]

## Problem Statement:
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

**Example 1:**

_Input_: s = "the sky is blue"

_Output_: "blue is sky the"

**Example 2:**

_Input_: s = "  hello world  "

_Output_: "world hello"

_Explanation_: Your reversed string should not contain leading or trailing spaces.

**Example 3:**

_Input_: s = "a good   example"

_Output_: "example good a"

_Explanation_: You need to reduce multiple spaces between two words to a single space in the reversed string.

## Solution (Using built-in Java functions)

✅ Step 1: Trim & Split:
Remove spaces at the beginning and end, use the regex \s+ to break the string into individual words (irrespective of the number of spaces in between them)

✅ Step 2: Reverse order:
Iterate the resulting array from end to start.

✅ Step 3: Reassemble:
Build the result with exactly one space between words.

### Time Complexity:
**O(n)** - trim, split and process all words in a string in linear time 

### Space Complexity:
**O(n)** - Split and new StringBuilder takes additional space (same as original string)

```java
public String reverseWords(String s) {
    String[] words = s.trim().split("\\s+");
    StringBuilder sb = new StringBuilder();

    for(int i = words.length - 1; i >=0; i--) {
        sb.append(words[i]);
        if(i != 0) {
            sb.append(" ");
        }
    }

    return sb.toString();
}
```

