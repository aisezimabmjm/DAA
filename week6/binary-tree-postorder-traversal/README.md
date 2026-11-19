# Problem 6: Binary Tree Postorder Traversal

## 1. Problem
Given the root of a binary tree, return the postorder traversal of its node values (Left -> Right -> Root).

## 2. Approach
I used a **Recursive DFS** approach:
1. Base case: Return if `node == null`.
2. Recursively visit the entire left subtree.
3. Recursively visit the entire right subtree.
4. Add `node.val` to the result list only after both children have been processed.

### Written Tracing Example
Input tree: `[1, null, 2, 3]`
- Start at `1`: left is `null`. Go right to `2`.
- At `2`: go left to `3`.
  - At `3`: left is `null`, right is `null` -> add `3` (`result = [3]`).
- Back at `2`: right is `null` -> add `2` (`result = [3, 2]`).
- Back at `1`: add `1` (`result = [3, 2, 1]`).
- Final output: `[3, 2, 1]`.

### Challenges Faced
- **Iterative Postorder Complexity**: Attempting an iterative single-stack postorder traversal required tracking the `lastVisited` node to avoid re-entering right subtrees. Using recursion simplified the logic and eliminated state-tracking bugs.

## 3. Time & Space Complexity
- **Time Complexity:** $O(n)$ — Each of the $n$ nodes is processed once.
- **Space Complexity:** $O(h)$ — Auxiliary space comes from the recursion stack depth $h$ ($O(n)$ worst case, $O(\log n)$ balanced).

## 4. Reflection / Improvement
- **Is there a more efficient approach?** Yes, **Morris Postorder Traversal** achieves $O(1)$ auxiliary space, or a modified preorder (`Root -> Right -> Left`) reversed at the end simplifies iterative stack implementation.
