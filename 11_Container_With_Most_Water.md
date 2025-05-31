# [Leetcode 11: Container With Most Water](https://leetcode.com/problems/container-with-most-water/description/) [2-pointers] [Medium]

## Problem Statement:
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

**Example 1:**

![Example 1](static/containerWithMostWater.jpg)

_Input_: height = [1,8,6,2,5,4,8,3,7]

_Output_: 49

_Explanation_: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

**Example 2:**

_Input_: height = [1,1]

_Output_: 1

## Solution (Using Two Pointers)
The amount of water a container can hold is determined by:
```
Height = min(height[i], height[j])
Width = j - i
Area = height × width
```

### 🧠 Core Idea:
* Use two pointers starting from both ends of the array:
* Calculate area between the lines at i and j
* Move the pointer pointing to the shorter line, since the limiting factor is the height.
  * Moving the taller line won't help increase the area.
* Repeat until the pointers meet.

### Time Complexity:
**O(n)** - Single pass through the array using two pointers

### Space Complexity:
**O(1)** - No additional datastructures is created

```java
public int maxArea(int[] height) {
    int i = 0, j = height.length - 1;
    int maxArea = 0;

    int minHeight = 0;
    int area = 0;
    while(i < j) {
        minHeight = Math.min(height[i], height[j]);
        area = minHeight * (j - i);
        maxArea = Math.max(area, maxArea);
        if(height[i] < height[j]) {
            i++;
        } else {
            j--;
        }
    }

    return maxArea;
}
```
