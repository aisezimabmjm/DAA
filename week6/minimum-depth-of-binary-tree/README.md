# Problem 3: Minimum Depth of Binary Tree

## 1. Problem
Given a binary tree, find its minimum depth—the shortest path from the root node down to the nearest leaf node (a node with no children).

## 2. Approach
I implemented a **Recursive DFS** approach with explicit handling for single-child nodes:
1. If `root == null`, return `0`.
2. If one child is `null`, we cannot take `Math.min` with `0` because a node with one child is not a leaf. Instead, recurse strictly into the non-null child.
3. If both children exist, return `1 + Math.min(minDepth(root.left), minDepth(root.right))`.

### Written Tracing Example
Input skewed tree: `2 -> right: 3 -> right: 4`
- At `2`: `left` is `null`, so we recurse only on `right` (`3`).
- At `3`: `left` is `null`, so we recurse only on `right` (`4`).
- At `4`: both `left` and `right` are `null`, returns `1 + min(0, 0) = 1`.
- Unwinding back to `3`: returns `1 + 1 = 2`.
- Unwinding back to `2`: returns `1 + 2 = 3`.

### Challenges Faced
- **Failed Naive Approach**: Initially, I copied the Maximum Depth formula and simply replaced `Math.max` with `Math.min`. This failed on skewed trees like `[2, null, 3, null, 4]` because `min(0, rightDepth)` always evaluated to `0`, treating `null` branches as leaves. Adding `null` child checks solved this bug.

## 3. Time & Space Complexity
- **Time Complexity:** $O(n)$ — In the worst case, all $n$ nodes are visited.
- **Space Complexity:** $O(h)$ — Recursion stack takes space proportional to tree height $h$ ($O(n)$ worst case, $O(\log n)$ balanced).

## 4. Reflection / Improvement
- **Is there a more efficient approach?** Yes, **Breadth-First Search (BFS)** is much faster in practice for unbalanced trees.
- **What would need to change?** Traverse the tree level by level with a `Queue`. As soon as the first node with both `left == null` and `right == null` is encountered, return the current level immediately without exploring deeper subtrees.
