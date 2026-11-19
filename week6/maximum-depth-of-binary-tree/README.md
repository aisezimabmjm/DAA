# Problem 2: Maximum Depth of Binary Tree

## 1. Problem
Given the root of a binary tree, find its maximum depth, defined as the number of nodes along the longest path from the root node down to the farthest leaf node.

## 2. Approach
I used a **Bottom-Up Recursive DFS** approach:
1. Base case: An empty node (`null`) has a depth of `0`.
2. Recursively compute the maximum depth of the left subtree and the right subtree.
3. Return `1 + Math.max(leftDepth, rightDepth)` to account for the current node.

### Written Tracing Example
Input tree: `[3, 9, 20, null, null, 15, 7]`
- `maxDepth(9)`: left is `0`, right is `0` -> returns `1 + max(0, 0) = 1`.
- `maxDepth(15)`: returns `1`.
- `maxDepth(7)`: returns `1`.
- `maxDepth(20)`: `1 + max(1, 1) = 2`.
- `maxDepth(3)`: `1 + max(1, 2) = 3`.
- Final result: `3`.

### Challenges Faced
- **Off-by-One Counting**: At first, I counted edges instead of nodes (returning `-1` for `null`), which gave an answer smaller by 1. Adjusting the base case to `0` for `null` fixed the node count.

## 3. Time & Space Complexity
- **Time Complexity:** $O(n)$ — Each of the $n$ nodes is visited once to compute its height.
- **Space Complexity:** $O(h)$ — The call stack holds at most $h$ recursive frames, where $h$ is the tree height ($O(n)$ worst case, $O(\log n)$ balanced).

## 4. Reflection / Improvement
- **Is there a more efficient approach?** Asymptotically $O(n)$ time is optimal since all nodes must be checked. However, an **Iterative BFS (Level-Order Traversal)** using a queue avoids `StackOverflowError` on extremely deep skewed trees.
- **What would need to change?** Use a `Queue<TreeNode>` to process nodes level by level and increment a `depth` counter after finishing each level.
