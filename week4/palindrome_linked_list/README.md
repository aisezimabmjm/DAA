# Palindrome Linked List

## 1. Problem
Given the head of a singly linked list, return `true` if it is a palindrome or `false` otherwise.

## 2. Approach
I implemented an in-place $O(1)$ auxiliary space algorithm divided into three stages:
1. **Find Middle:** Use fast and slow pointers (`fast` moves 2 steps, `slow` moves 1 step). When `fast` reaches the end, `slow` is at the middle.
2. **Reverse Second Half:** Reverse the sublist starting from `slow` iteratively using three pointers (`prev`, `current`, `nextTemp`).
3. **Compare Halves:** Iterate simultaneously through the first half (`head`) and the reversed second half (`prev`), comparing node values.

### Step-by-Step Tracing Example
Input: `head = [1, 2, 2, 1]`

- **Stage 1 (Find Middle):** `slow` reaches second `2`.
- **Stage 2 (Reverse Second Half):** Sublist `[2, 1]` becomes `[1, 2]`. Head of reversed second half is node `1` (`prev`).
- **Stage 3 (Compare Halves):**
  - Iteration 1: `firstHalf.val` (1) == `secondHalf.val` (1). Move both.
  - Iteration 2: `firstHalf.val` (2) == `secondHalf.val` (2). Move both.
  - `secondHalf` becomes `null`. Loop ends.
- **Result:** `true`

### Challenges Faced
- **Array Conversion ($O(N)$ Space):** Copying values into an `ArrayList` and using two pointers was easy to implement, but failed the $O(1)$ extra space constraint.
- **In-Place Reversal Pointers:** Reversing the second half directly caused pointer confusion when trying to restore or traverse the list. Breaking the algorithm down into distinct helper steps solved the bug.

## 3. Complexity Analysis

* **Time Complexity:** $O(N)$
  - **Reason:** Finding the middle takes $N/2$ steps, reversing takes $N/2$ steps, and comparison takes $N/2$ steps. Total operations $= 1.5N = O(N)$.

* **Space Complexity:** $O(1)$
  - **Reason:** Modifications are performed directly on existing node pointers without extra data structures.

## 4. Reflection / Improvement
- **Restoration:** A complete production implementation should reverse the second half back to its original state before returning to maintain immutability of the input list.
