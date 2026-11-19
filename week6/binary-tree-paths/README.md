# Problem 8: Binary Tree Paths

## 1. Problem
Given the root of a binary tree, return all root-to-leaf paths formatted as `"val1->val2->...->leaf"`.

## 2. Approach
I implemented **Recursive DFS with Backtracking** using a `StringBuilder`:
1. Save the current length `len` of the `StringBuilder` before appending `node.val`.
2. If the node is a leaf (`left == null && right == null`), convert the `StringBuilder` to a `String` and add it to `paths`.
3. Otherwise, append `"->"` and recurse on non-null children.
4. Restore `path.setLength(len)` after returning from children to backtrack cleanly.

### Written Tracing Example
Input tree: `[1, 2, 3, null, 5]`
- Start at `1` (`len = 0`): `path = "1->"`. Go left to `2`.
- At `2` (`len = 3`): `path = "1->2->"`. Left is `null`, go right to `5`.
- At `5` (`len = 6`): `path = "1->2->5"`. Leaf reached -> add `"1->2->5"` to `paths`. Backtrack to `len = 6`.
- Back at `2`: backtrack to `len = 3` (`path = "1->"`).
- Back at `1`: go right to `3` (`len = 3`): `path = "1->3"`. Leaf reached -> add `"1->3"` to `paths`.
- Final output: `["1->2->5", "1->3"]`.

### Challenges Faced
- **String Immutability Overhead**: My first attempt used `String path + node.val + "->"`. Because Java `String` objects are immutable, each recursive call allocated a new string copy, leading to $O(n^2)$ memory allocation. Switching to a mutable `StringBuilder` with `setLength()` backtracking eliminated redundant string copies.

## 3. Time & Space Complexity
- **Time Complexity:** $O(n \cdot h)$ — Visiting all nodes takes $O(n)$, and converting `StringBuilder` to `String` at each leaf takes up to $O(h)$ time per leaf.
- **Space Complexity:** $O(h)$ — Auxiliary space for the recursion stack and `StringBuilder` buffer is proportional to tree height $h$ ($O(n)$ worst case).

## 4. Reflection / Improvement
- **Is there a more efficient approach?** Asymptotically, generating all root-to-leaf path strings requires at least proportional output size. Using `StringBuilder` with backtracking is already optimal in Java for minimizing intermediate garbage collection.
