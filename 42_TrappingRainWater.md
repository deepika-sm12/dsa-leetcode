# [Leetcode 42: Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/description/) [2-pointers] [Hard]

## Problem Statement:
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

**Example 1:**

![Example1](static/rainwatertrap.png)

_Input_: height = [0,1,0,2,1,0,1,3,2,1,2,1]

_Output_: 6

_Explanation_: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

**Example 2:**

_Input_: height = [4,2,0,3,2,5]

_Output_: 9

## ✅ Intuition:
We use a **two-pointer approach** to simulate how water gets trapped between walls of different heights.

## Solution
🧠 **Core Idea:**
The amount of water trapped at any index depends on the shorter boundary on either side of it.

Mathematically:

```waterAt[i] = min(maxLeft, maxRight) - height[i]```

Instead of precomputing max values for every index (which takes extra space), use two pointers:
* left starting at index 0
* right starting at the end

Track the highest wall seen so far on both sides: `maxLeft` and `maxRight`.

At each step:
1. Move the pointer that has the lower max height so far.
2. Calculate trapped water at the new position using that side’s max.
3. This works because water can’t rise above the shorter boundary.

This results in a single pass with constant space.

## 🔑 Key Observations:
1. **Water is limited by the shorter wall:**
    Always move the pointer with the smaller max height.
    Hence the condition: if (maxLeft < maxRight).
2. **Always move the pointer first, then calculate:**
    This ensures the calculation is based on the new position, not the current one.
3. **Ignore the opposite side while calculating:**
    If maxLeft < maxRight, the trapped water is determined entirely by maxLeft.
    The right side doesn’t affect the current calculation because water can only rise as high as the shorter boundary.

## 🧩 Mnemonic:
```**Move Short, Update Max, Measure Depth**```

1. Move Short side (based on maxLeft vs maxRight)
2. Update Max value at that pointer
3. Measure Depth as max - height[i] (only if max > height[i])

### Time Complexity:
**O(n)** - Each element in the height array is processed only once.

### Space Complexity:
**O(1)** - No additional arrays or data structures are used.

```java
public static int trap(int[] height) {
    int maxLeft = height[0];
    int maxRight = height[height.length - 1];
    int left = 0;
    int right = height.length;

    int totalTrappedWater = 0;
    int trappedWaterAtIdx;

    while(left < right) {
        if(maxLeft < maxRight) {
            left++;
            maxLeft = Math.max(maxLeft, height[left]);
            trappedWaterAtIdx = maxLeft - height[left];
            if(trappedWaterAtIdx > 0) {
                totalTrappedWater += trappedWaterAtIdx;
            }
        } else {
            right--;
            maxRight = Math.max(maxRight, height[right]);
            trappedWaterAtIdx = maxRight - height[right];
            if(trappedWaterAtIdx > 0) {
                totalTrappedWater += trappedWaterAtIdx;
            }
        }
    }

    return totalTrappedWater;
}
```

