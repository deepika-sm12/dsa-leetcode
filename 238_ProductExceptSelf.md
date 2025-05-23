# [Leetcode 238: Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/description/) [Array] [Medium]

## Problem Statement:
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and **_WITHOUT using the DIVISION operation_**.

**Example 1:**

Input: nums = [1,2,3,4]

Output: [24,12,8,6]


**Example 2:**

Input: nums = [-1,1,0,-3,3]

Output: [0,0,9,0,0]

## Solution 1
1. For each element, find the product of the PREFIX elements
2. For each element, find the product of the SUFFIX elements
3. For each element, multiply prefix product with suffix product

### Time Complexity:
**O(n)** - array is parsed only once

### Space Complexity:
**O(n)** - creates additional arrays for storing prefix and suffix products

```java
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] prefixProduct = new int[n];
    int[] suffixProduct = new int[n];
    int[] finalProduct = new int[n];

    prefixProduct[0] = 1;
    suffixProduct[n - 1] = 1;

    // Populate prefix products
    for(int i = 1; i < n; i++) {
        prefixProduct[i] = nums[i - 1] * prefixProduct[i - 1];
    }

    // Populate suffix products
    for(int i = n - 2; i >= 0; i--) {
        suffixProduct[i] = nums[i + 1] * suffixProduct[i + 1];
    }

    // Populalte final product
    for(int i = 0; i < n; i++) {
        finalProduct[i] = prefixProduct[i] * suffixProduct[i];
    }

    return finalProduct;
}
```

## Solution 2 (For the followup challenge)
Followup challenge: O(1) space complexity, output array DOES NOT count as extra space for space complexity analysis
1. For each element, find the product of the PREFIX elements and store in output array
2. Initialize a counter to store the latest suffix product
2. For each element (from last) except the last element, 

   2.1 find the latest suffix product by multiplying it with the next element
   
   2.2 multiple its prefix product with the latest suffix prodcut

### Time Complexity:
**O(n)** - array is parsed only once

### Space Complexity:
**O(1)** - no additional arrays are created to store the prefix and suffix products

```java
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] output = new int[n];

    // Populate prefix products
    output[0] = 1;
    for(int i = 1; i < n; i++) {
        output[i] = nums[i - 1] * output[i - 1];
    }

    // Calculate the latest suffix product and multiply with prefix product
    int latestSuffixProduct = 1;

    // not calculating for the last element since there is no suffix product - prefix product is the final product
    for(int i = n - 2; i >= 0; i--) {
        latestSuffixProduct = latestSuffixProduct * nums[i + 1];
        output[i] = latestSuffixProduct * output[i];
    }

    return output;
}
```
