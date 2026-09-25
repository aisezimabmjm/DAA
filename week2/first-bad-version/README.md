# First Bad Version

## 1. Problem
Suppose you have `n` versions `[1, 2, ..., n]` and you want to find out the first bad version, which causes all the following ones to be bad. You are given an API `isBadVersion(version)` which returns whether `version` is bad.

## 2. Approach
We use Binary Search to find the first bad version:
1. Initialize two pointers: `left = 1` and `right = n`.
2. Calculate the middle index: `mid = left + (right - left) / 2`.
3. Call `isBadVersion(mid)`:
    - If `true`, the first bad version is at `mid` or to the left of `mid`, so we set `right = mid`.
    - If `false`, the first bad version is to the right of `mid`, so we set `left = mid + 1`.
4. The search ends when `left == right`, pointing to the first bad version.

## 3. Time Complexity
**Time Complexity:** O(log n)

**Explanation:** In each iteration, the search range is divided in half. Therefore, the number of operations grows logarithmically with `n`.

## 4. Space Complexity
**Space Complexity:** O(1)

**Explanation:** The solution only uses a few primitive variables (`left`, `right`, `mid`), requiring constant extra space.

## 5. Reflection / Improvement
This $O(\log n)$ approach is already optimal in terms of time and space complexity. Using `left + (right - left) / 2` avoids potential integer overflow errors compared to `(left + right) / 2`.