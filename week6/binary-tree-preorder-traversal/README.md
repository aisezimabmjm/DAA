# Problem 5: Binary Tree Preorder Traversal

## 1. Problem
Given the root of a binary tree, return the preorder traversal of its node values (Root -> Left -> Right).

## 2. Approach
I implemented a **Recursive DFS** approach:
1. Base case: If `node == null`, return.
2. Record `node.val` immediately upon visiting the node.
3. Recursively traverse the left child, followed by the right child.

### Written Tracing Example
Input tree: `[1, null, 2, 3]`
- Visit `1`: `result = [1]`.
- Recurse left (`null` -> returns).
- Recurse right to `2`:
  - Visit `2`: `result = [1, 2]`.
  - Recurse left to `3`:
    - Visit `3`: `result = [1, 2, 3]`.
    - Left and right of `3` are `null`.
  - Recurse right of `2` (`null`).
- Final output: `[1, 2, 3]`.

### Challenges Faced
- **Creating New Lists in Recursion**: Initially, I instantiated a new `ArrayList` inside every recursive call and merged them via `addAll()`, which caused unnecessary copying overhead. Passing a single shared `result` list by reference made the solution clean and $O(n)$.

## 3. Time & Space Complexity
- **Time Complexity:** $O(n)$ — Every node is visited and appended to the list once.
- **Space Complexity:** $O(h)$ — Auxiliary space is used by the recursion call stack of height $h$ ($O(n)$ worst case, $O(\log n)$ balanced).

## 4. Reflection / Improvement
- **Is there a more efficient approach?** Yes, **Morris Preorder Traversal** reduces auxiliary space complexity to $O(1)$.
- **What would need to change?** Use threaded binary tree links (connecting inorder predecessors to current nodes) to navigate back up the tree without a recursion stack or explicit `Stack`.
