# Problem 7: Invert Binary Tree

## 1. Problem
Given the root of a binary tree, mirror/invert the tree by swapping every left child with its corresponding right child, and return its root.

## 2. Approach
I used a **Recursive DFS** approach:
1. Base case: If `root == null`, return `null`.
2. Save the original `root.left` reference in a temporary variable `temp`.
3. Recursively invert the right subtree and assign it to `root.left`.
4. Recursively invert `temp` (original left subtree) and assign it to `root.right`.
5. Return `root`.

### Written Tracing Example
Input tree: `[4, 2, 7, 1, 3, 6, 9]`
- At `4`: saves `2` in `temp`. Calls `invertTree(7)` and `invertTree(2)`.
- At `7`: swaps children `6` and `9` -> becomes `[7, 9, 6]`.
- At `2`: swaps children `1` and `3` -> becomes `[2, 3, 1]`.
- Back at `4`: `4.left` becomes `7`, `4.right` becomes `2`.
- Final tree: `[4, 7, 2, 9, 6, 3, 1]`.

### Challenges Faced
- **Overwriting Subtree Reference**: Initially, I wrote `root.left = invertTree(root.right); root.right = invertTree(root.left);` without a temporary variable. This overwrote `root.left` before it could be assigned to `root.right`, duplicating the right subtree. Saving `temp = root.left` solved the bug.

## 3. Time & Space Complexity
- **Time Complexity:** $O(n)$ — Every node in the tree is visited and swapped once.
- **Space Complexity:** $O(h)$ — Auxiliary space is used by the recursion stack of height $h$ ($O(n)$ worst case, $O(\log n)$ balanced).

## 4. Reflection / Improvement
- **Is there a more efficient approach?** Time complexity cannot be improved beyond $O(n)$ since every node must be swapped. However, an **Iterative BFS** approach using a `Queue` avoids deep recursion stack usage on skewed trees.
