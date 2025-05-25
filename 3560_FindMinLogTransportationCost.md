# [Leetcode 3560. Find Minimum Log Transportation Cost](https://leetcode.com/problems/find-minimum-log-transportation-cost/description/) [Math] [Easy]

## Problem Statement:
You are given integers n, m, and k.

There are two logs of lengths n and m units, which need to be transported in three trucks where each truck can carry one log with length at most k units.

You may cut the logs into smaller pieces, where the cost of cutting a log of length x into logs of length len1 and len2 is cost = len1 * len2 such that len1 + len2 = x.

Return the minimum total cost to distribute the logs onto the trucks. If the logs don't need to be cut, the total cost is 0.

**Example 1:**

_Input_: n = 6, m = 5, k = 5

_Output_: 5

_Explanation_: Cut the log with length 6 into logs with length 1 and 5, at a cost equal to 1 * 5 == 5. Now the three logs of length 1, 5, and 5 can fit in one truck each.

**Example 2:**

_Input_: n = 4, m = 4, k = 6

_Output_: 0

_Explanation_: The two logs can fit in the trucks already, hence we don't need to cut the logs.

## Solution
Only the longer log needs to be cut once to fit the trucks. One piece is made exactly size k (the maximum allowed), and the other piece is the remainder (x - k). This single cut ensures both pieces fit within the size limit and results in the minimum possible cutting cost, since the product k * (x - k) is the smallest cost achievable under these conditions. 

If both logs already fit without cutting, the cost is zero.

### Time Complexity:
**O(1)** - calculation involves only a few constant-time operations without loops

### Space Complexity:
**O(1)** - No additional datastructures is created

```java
public long minCuttingCost(int n, int m, int k) {
    if(n <= k && m <= k) return 0;

    int x = Math.max(n, m);

    return (long) k * (x - k);
}
```

