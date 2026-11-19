# Problem 4: Path Sum

## 1. Problem
Given the root of a binary tree and an integer `targetSum`, determine if there is a complete root-to-leaf path whose node values add up to `targetSum`.

## 2. Approach
I used a **Top-Down Recursive DFS** subtraction method:
1. If `root == null`, return `false` (no valid path).
2. If the current node is a leaf (`left == null && right == null`), check if `root.val == targetSum`.
3. Otherwise, subtract `root.val` from `targetSum` and recursively check either the left or right subtree.

### Written Tracing Example
Input: `root = [5, 4, 8, 11]`, `targetSum = 20` (path `5 -> 4 -> 11`)
- At `5`: not a leaf; `remaining = 20 - 5 = 15`. Go left to `4`.
- At `4`: not a leaf; `remaining = 15 - 4 = 11`. Go left to `11`.
- At `11`: leaf node (`left == null && right == null`). Check `11 == 11` -> returns `true`.
- `true || hasPathSum(right)` short-circuits and returns `true`.

### Challenges Faced
- **False Positives on Non-Leaf Nodes**: Initially, I checked `if (root == null) return targetSum == 0;`. This failed for input `root = [1, 2], targetSum = 1` because node `1`'s right child is `null`, falsely treating the root itself as a completed path. Checking leaf status explicitly fixed the issue.

## 3. Time & Space Complexity
- **Time Complexity:** $O(n)$ — In the worst case (when no valid path exists), every node is visited once.
- **Space Complexity:** $O(h)$ — Recursion stack depth equals the tree height $h$ ($O(n)$ worst case, $O(\log n)$ balanced).

## 4. Reflection / Improvement
- **Is there a more efficient approach?** $O(n)$ time is optimal because any leaf could hold the target sum. An iterative DFS using two stacks (one for nodes, one for running sums) can prevent call stack overflow on very deep trees while keeping $O(h)$ space.
