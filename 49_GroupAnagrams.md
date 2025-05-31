# [Leetcode 49: Group Anagrams](https://leetcode.com/problems/group-anagrams/description/) [Hashing] [Medium]

## Problem Statement:
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

**Example 1:**

_Input_: strs = ["eat","tea","tan","ate","nat","bat"]

_Output_: [["bat"],["nat","tan"],["ate","eat","tea"]]

_Explanation_:
* There is no string in strs that can be rearranged to form "bat".
* The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
* The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

**Example 2:**

_Input_: strs = [""]

_Output_: [[""]]

**Example 3:**

_Input_: strs = ["a"]

_Output_: [["a"]]

## Solution 1: Using Sorted Word as Key (Intuitive)
If two words are anagrams, sorting their characters will give the same string.
Example: "eat", "tea", and "ate" → all become "aet" when sorted.

### 🧠 Core Idea:
* Sort each string to get a canonical form.
* Use the sorted string as a key in a HashMap.
* Group all strings with the same key together.

### Time Complexity:
**O(k log k)** - every string gets sorted, k = average word length

### Space Complexity:
**O(n)** - hashmap to store the keys

```java
public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> anagramMap = new HashMap<>();

    for(String str: strs) {
        char[] chars= str.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);

        anagramMap.putIfAbsent(key, new ArrayList<>());
        anagramMap.get(key).add(str);
    }

    return new ArrayList<>(anagramMap.values());
}
```

## Solution 2: Using Character Count as Key (Optimal)
Instead of sorting, count the frequency of each character (from 'a' to 'z').
All anagrams will have the same character count array.
Example:
* `"eat"` → `[1, 0, ..., 1, 0, ..., 1]`
* `"tea"` → `[1, 0, ..., 1, 0, ..., 1]` -- same
* Convert the count array to a string key like: `#1#0#0#1#0...#1`

### 🧠 Core Idea:
* Use a `char[26]` array to count each letter.
* Convert the count into a string (delimited) to use as a map key.
* Group strings with the same count signature.

### Time Complexity:
* For n strings: `O(n * k)` → k = average word length → more efficient than sorting

### Space Complexity:
**O(n)** - hashmap to store the keys

```java
public List<List<String>> groupAnagramsByCharCount(String[] strs) {
    Map<String, List<String>> anagramMap = new HashMap<>();

    for(String str: strs) {
        String key = getAnagramKey(str);
        if(!anagramMap.containsKey(key)) {
            anagramMap.put(key, new ArrayList<>());
        }
        anagramMap.get(key).add(str);
    }
    return new ArrayList<>(anagramMap.values());
}

private static String getAnagramKey(String str) {
    int[] charCount = new int[26];
    for(char c: str.toCharArray()) {
        charCount[c - 'a']++;
    }
    StringBuilder anagramKey = constructAnagramKey(charCount);
    return anagramKey.toString();
}

private static StringBuilder constructAnagramKey(int[] charCount) {
    StringBuilder anagramKey = new StringBuilder();
    for(int count: charCount) {
        anagramKey.append("#");
        anagramKey.append(count);
    }
    return anagramKey;
}
```