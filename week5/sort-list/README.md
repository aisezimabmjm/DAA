# Problem 2: Sort List

## 1. Problem
Given the head of a singly linked list, sort the list in ascending order and return its head.

## 2. Approach
I used **Merge Sort** tailored for linked lists:
1. Find the middle node using the Fast & Slow Pointer algorithm.
2. Disconnect the left half from the right half (`slow.next = null`).
3. Recursively sort both sublists.
4. Merge the two sorted linked lists using a dummy node.

### Written Tracing Example
Input: `4 -> 2 -> 1 -> 3`
- Find mid: split into `4 -> 2` and `1 -> 3`.
- Sort `4 -> 2` -> yields `2 -> 4`.
- Sort `1 -> 3` -> yields `1 -> 3`.
- Merge `2 -> 4` and `1 -> 3`:
  - Compare 2 and 1 -> append 1
  - Compare 2 and 3 -> append 2
  - Compare 4 and 3 -> append 3
  - Append remaining 4
  - Result: `1 -> 2 -> 3 -> 4`.

### Challenges Faced
- Forgetting to disconnect `slow.next = null` causes infinite recursion.
- Setting `fast = head.next` prevents infinite loops on 2-element lists.

## 3. Complexity
- **Time Complexity:** $O(n \log n)$ — Midpoint search takes $O(n)$ per level across $\log n$ levels.
- **Space Complexity:** $O(\log n)$ — Recursion call stack memory.

## 4. Reflection / Improvement
- Bottom-up (Iterative) Merge Sort can achieve $O(1)$ auxiliary space complexity.
