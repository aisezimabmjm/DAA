# Remove Duplicates from Sorted List

## 1. Problem
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

## 2. Approach
Since the list is already sorted, duplicate values are adjacent:
1. Traverse the list starting from `head` using a pointer `current`.
2. Compare `current.val` with `current.next.val`.
3. If they are equal, skip the next node by re-linking `current.next = current.next.next`.
4. If they are different, simply advance `current` to `current.next`.

### Step-by-Step Tracing Example
Input: `head = [1, 1, 2, 3, 3]`

- **Initial:** `current` at node `1` (first).
- **Iteration 1:** `1 == 1` (duplicate found). Set `1.next` to `2`. List becomes `[1, 2, 3, 3]`. `current` remains at first `1`.
- **Iteration 2:** `1 != 2`. Move `current` to `2`.
- **Iteration 3:** `2 != 3`. Move `current` to first `3`.
- **Iteration 4:** `3 == 3` (duplicate found). Set `3.next` to `null`. List becomes `[1, 2, 3]`.
- **End:** `current.next` is `null`. Loop terminates.
- **Result:** `[1, 2, 3]`

### Challenges Faced
- **Incorrect Pointer Movement:** Initially, I moved `current = current.next` in every iteration. This caused a bug when three identical elements existed (e.g., `[1, 1, 1]`) because skipping only removed the middle node without re-checking the new `current.next`. Updating `current` only when values differ solved this issue.

## 3. Complexity Analysis

* **Time Complexity:** $O(N)$
  - **Reason:** We visit each node in the linked list at most once, performing a constant-time check at each step.

* **Space Complexity:** $O(1)$
  - **Reason:** No extra data structures are used; the operation is performed in-place.

## 4. Reflection / Improvement
- **Is there a more efficient approach?** The time complexity $O(N)$ is optimal because every node must be checked.
- **Alternative:** A recursive approach can be implemented, but it would use $O(N)$ auxiliary space on the call stack, making this iterative approach superior in space efficiency.
