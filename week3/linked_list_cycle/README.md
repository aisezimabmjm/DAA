# Linked List Cycle

## 1. Problem
Given the head of a linked list, determine if the linked list contains a cycle. A cycle exists if a node can be reached again by continuously following the `next` pointer.

## 2. Approach
I implemented Floyd’s Cycle-Finding Algorithm (Two Pointers / "Tortoise and Hare"):
1. Initialize two pointers, `slow` and `fast`, at the head of the list.
2. Traverse the list moving `slow` by 1 step and `fast` by 2 steps in each iteration.
3. If there is a cycle, the `fast` pointer will eventually catch up to the `slow` pointer inside the loop.
4. If `fast` reaches `null` (end of list), there is no cycle.

### Step-by-Step Tracing Example
Input: `3 -> 2 -> 0 -> -4` (where `-4` points back to `2`)

- **Initial State:** `slow` at `3`, `fast` at `3`.
- **Iteration 1:**
  - `slow` moves to `2`.
  - `fast` moves to `0`.
- **Iteration 2:**
  - `slow` moves to `0`.
  - `fast` moves to `2` (following `-4` -> `2`).
- **Iteration 3:**
  - `slow` moves to `-4`.
  - `fast` moves to `-4` (following `0` -> `-4`).
- **Condition Match:** `slow == fast` (both point to `-4`).
- **Return:** `true`.

## 3. Complexity Analysis

* **Time Complexity:** $O(N)$
  - **Reason:** If there is no cycle, `fast` reaches the end in $N / 2$ steps. If there is a cycle, `fast` catches up to `slow` within a distance bounded by the cycle length ($K \le N$). In both cases, time complexity is linear, $O(N)$.

* **Space Complexity:** $O(1)$
  - **Reason:** We only use two pointer variables (`slow` and `fast`), regardless of the size of the linked list.

## 4. Reflection / Improvement
- **Alternative Approach:** Another common solution uses a Hash Set to store visited nodes.
  - **Drawback of Hash Set:** It requires $O(N)$ auxiliary space.
- **Conclusion:** The Two-Pointer (Floyd's) approach is optimal in terms of both time ($O(N)$) and space ($O(1)$).
