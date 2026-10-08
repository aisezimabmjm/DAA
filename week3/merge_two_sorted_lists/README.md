# Merge Two Sorted Lists

## 1. Problem
Given the heads of two sorted linked lists, `list1` and `list2`. Merge the two lists into one sorted linked list by splicing together the nodes of the first two lists, and return the head of the merged list.

## 2. Approach
I used an iterative approach with a dummy node:
1. Create a `dummy` node to serve as the start of the merged list, and a pointer `current` initialized to `dummy`.
2. Compare the current elements of `list1` and `list2`.
3. Attach the smaller node to `current.next` and move the pointer of that list forward.
4. Move `current` forward.
5. Repeat until one of the lists becomes empty.
6. Attach the remaining nodes from the non-empty list to `current.next`.

### Step-by-Step Tracing Example
Input: `list1 = [1, 2, 4]`, `list2 = [1, 3, 4]`

- **Initial State:** `dummy` -> `-1`, `current` -> `dummy`
- **Iteration 1:** Compare `1` (list1) and `1` (list2). `1 <= 1` is True.
  - `current.next` = `1` (from list1)
  - Move `list1` to node `2`.
- **Iteration 2:** Compare `2` (list1) and `1` (list2). `2 <= 1` is False.
  - `current.next` = `1` (from list2)
  - Move `list2` to node `3`.
- **Iteration 3:** Compare `2` (list1) and `3` (list2). `2 <= 3` is True.
  - `current.next` = `2` (from list1)
  - Move `list1` to node `4`.
- **Iteration 4:** Compare `4` (list1) and `3` (list2). `4 <= 3` is False.
  - `current.next` = `3` (from list2)
  - Move `list2` to node `4`.
- **Iteration 5:** Compare `4` (list1) and `4` (list2). `4 <= 4` is True.
  - `current.next` = `4` (from list1)
  - Move `list1` to `null`.
- **After Loop:** `list1` is empty. Attach remaining `list2` (`[4]`).
- **Result:** `[1, 1, 2, 3, 4, 4]`.

## 3. Complexity Analysis

* **Time Complexity:** $O(N + M)$
  - **Reason:** In each step of the while loop, we process exactly one node from either `list1` or `list2`. Therefore, the maximum number of iterations is proportional to the total number of nodes in both lists ($N + M$).

* **Space Complexity:** $O(1)$
  - **Reason:** No additional data structures are created. We only adjust pointers between existing nodes and create one dummy variable.

## 4. Reflection / Improvement
- **Is there a more efficient approach?** The $O(N + M)$ time complexity is optimal because every node must be visited at least once to determine order.
- **Alternative Approach:** A recursive approach can be used, but it would require $O(N + M)$ auxiliary space due to the call stack. Thus, the iterative approach is optimal in space efficiency.
