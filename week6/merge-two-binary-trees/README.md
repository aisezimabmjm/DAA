# Problem 10: Merge Two Binary Trees

## 1. Problem
Given two binary trees `root1` and `root2`, merge them into a single binary tree by summing overlapping node values and keeping non-null nodes where one tree lacks a node.

## 2. Approach
I implemented an **In-Place Recursive DFS** approach:
1. If `root1` is `null`, return `root2` directly (attaching the remaining subtree).
2. If `root2` is `null`, return `root1` directly.
3. If both exist, add `root2.val` into `root1.val`.
4. Recursively merge `root1.left` with `root2.left`, and `root1.right` with `root2.right`.
5. Return `root1`.

### Written Tracing Example
Input: `root1 = [1, 3, 2, 5]`, `root2 = [2, 1, 3, null, 4, null, 7]`
- Root (`1` and `2`): both exist -> `root1.val = 1 + 2 = 3`.
- Left (`3` and `1`): both exist -> `val = 3 + 1 = 4`.
  - Left-Left (`5` and `null`): `root2` is `null` -> returns node `5`.
  - Left-Right (`null` and `4`): `root1` is `null` -> returns node `4`.
- Right (`2` and `3`): both exist -> `val = 2 + 3 = 5`.
  - Right-Left (`null` and `null`): returns `null`.
  - Right-Right (`null` and `7`): `root1` is `null` -> returns node `7`.
- Final merged tree: `[3, 4, 5, 5, 4, null, 7]`.

### Challenges Faced
- **Unnecessary Node Allocation**: My initial solution created `new TreeNode(root1.val + root2.val)` at every step and cloned subtrees even when one tree was `null`. Updating `root1` in-place and returning the non-null subtree reference directly eliminated unnecessary memory allocations.

## 3. Time & Space Complexity
- **Time Complexity:** $O(\min(n, m))$ — We only recurse while both `root1` and `root2` are non-null, where $n$ and $m$ are the node counts of the two trees.
- **Space Complexity:** $O(\min(h_1, h_2))$ — Recursion depth is bounded by the shorter overlapping height of the two trees ($O(\min(n, m))$ worst case, $O(\log(\min(n, m)))$ balanced).

## 4. Reflection / Improvement
- **Is there a more efficient approach?** Updating `root1` in-place is already optimal in both time $O(\min(n, m))$ and auxiliary space. If mutating input trees is not allowed in a production setting, allocating new `TreeNode` instances would be required at the cost of $O(n + m)$ space.
