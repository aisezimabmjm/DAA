# Problem 1: Sort an Array

## 1. Problem
Given an unsorted array of integers `nums`, sort the array in ascending order without using built-in sorting functions.

## 2. Approach
I implemented **Merge Sort** using a divide-and-conquer strategy:
1. Split the array recursively into two halves until single-element arrays remain.
2. Merge the sorted halves back together in sorted order using two pointers and a temporary array.

### Written Tracing Example
Input: `nums = [5, 2, 3, 1]`
- **Divide**: Split `[5, 2, 3, 1]` into `[5, 2]` and `[3, 1]`.
- **Recurse Left**: Split `[5, 2]` into `[5]` and `[2]`. Merge to get `[2, 5]`.
- **Recurse Right**: Split `[3, 1]` into `[3]` and `[1]`. Merge to get `[1, 3]`.
- **Final Merge**: Merge `[2, 5]` and `[1, 3]`:
  - Compare 2 and 1 -> pick 1
  - Compare 2 and 3 -> pick 2
  - Compare 5 and 3 -> pick 3
  - Remaining element -> 5
  - Final result: `[1, 2, 3, 5]`.

### Challenges Faced
- QuickSort with a fixed pivot gave a Time Limit Exceeded (TLE) error on LeetCode for pre-sorted/duplicate-heavy inputs.
- Switched to Merge Sort to guarantee $O(n \log n)$ worst-case performance.

## 3. Complexity
- **Time Complexity:** $O(n \log n)$ — Recursion tree depth is $\log_2 n$, and at each level, merging takes $O(n)$ time.
- **Space Complexity:** $O(n)$ — Additional temporary memory is required for merging elements.

## 4. Reflection / Improvement
- Heap Sort or In-Place Merge Sort can reduce space complexity to $O(1)$.
