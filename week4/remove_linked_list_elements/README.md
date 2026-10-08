# Remove Linked List Elements

## 1. Problem
Given the head of a linked list and an integer `val`, remove all the nodes of the linked list that have `Node.val == val`, and return the new head.

## 2. Approach
I used a dummy node technique to handle edge cases cleanly:
1. Create a `dummy` node pointing to `head` (`dummy.next = head`).
2. Initialize `current` at `dummy`.
3. Check `current.next.val`.
4. If `current.next.val == val`, bypass it by setting `current.next = current.next.next`.
5. Otherwise, advance `current = current.next`.
6. Return `dummy.next` as the new head.

### Step-by-Step Tracing Example
Input: `head = [1, 2, 6, 3, 4, 5, 6]`, `val = 6`

- **Initial:** `dummy` -> `1`, `current` points to `dummy`.
- **Step 1:** `1 != 6` -> move `current` to `1`.
- **Step 2:** `2 != 6` -> move `current` to `2`.
- **Step 3:** `6 == 6` -> set `2.next = 3`. List becomes `[1, 2, 3, 4, 5, 6]`.
- **Step 4:** `3 != 6` -> move `current` to `3`.
- **Step 5:** `4 != 6` -> move `current` to `4`.
- **Step 6:** `5 != 6` -> move `current` to `5`.
- **Step 7:** `6 == 6` -> set `5.next = null`.
- **Result:** `[1, 2, 3, 4, 5]`

### Challenges Faced
- **Deleting Head Nodes:** Trying to remove target nodes directly without a dummy node required messy `while (head != null && head.val == val)` pre-checks. If all elements in the list matched `val` (e.g., `[7, 7, 7]`), it easily resulted in `NullPointerException`. Using a dummy node unified the deletion logic for all positions.

## 3. Complexity Analysis

* **Time Complexity:** $O(N)$
  - **Reason:** Every node in the list is inspected exactly once in a single pass.

* **Space Complexity:** $O(1)$
  - **Reason:** Only one dummy node and one iterator pointer are allocated.

## 4. Reflection / Improvement
- **Is there a more efficient approach?** $O(N)$ time is optimal since every node must be checked.
- **Alternative:** A recursive approach is possible (`head.next = removeElements(head.next, val)`), but it incurs $O(N)$ space complexity due to recursion call stack frame overhead.
