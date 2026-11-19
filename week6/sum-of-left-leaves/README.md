# Problem 9: Sum of Left Leaves

## 1. Problem
Given the root of a binary tree, calculate the sum of all leaf nodes that are left children of their parent.

## 2. Approach
I used a **Recursive DFS** approach that checks left children from their parent node:
1. If `root == null`, return `0`.
2. Check if `root.left` exists and is a leaf (`root.left.left == null && root.left.right == null`). If so, add `root.left.val` to `sum`.
3. Otherwise, recursively find left leaves in `root.left`.
4. Always recursively find left leaves in `root.right` and add to `sum`.

### Written Tracing Example
Input tree: `[3, 9, 20, null, null, 15, 7]`
- At `3`: `3.left` is `9`, and `9` has no children -> `sum += 9`. Recurse on `3.right` (`20`).
- At `20`: `20.left` is `15`, and `15` has no children -> `sum += 15`. Recurse on `20.right` (`7`).
- At `7`: `7.left` is `null`, `7.right` is `null` -> returns `0`.
- Total sum: `9 + 15 = 24`.

### Challenges Faced
- **Single-Node Edge Case**: Initially, I passed a boolean flag `isLeft` and returned `root.val` whenever `left == null && right == null`. When testing a tree with just a single root node `[1]`, setting `isLeft = true` initially falsely counted the root as a left leaf. Checking `root.left` from the parent node cleanly avoided this edge case.

## 3. Time & Space Complexity
- **Time Complexity:** $O(n)$ — Every node in the binary tree is inspected once.
- **Space Complexity:** $O(h)$ — Auxiliary space is used by the recursion stack of height $h$ ($O(n)$ worst case, $O(\log n)$ balanced).

## 4. Reflection / Improvement
- **Is there a more efficient approach?** $O(n)$ time is optimal because all nodes must be checked to locate leaves. An iterative BFS queue can achieve the same $O(n)$ time without recursion stack limits.
