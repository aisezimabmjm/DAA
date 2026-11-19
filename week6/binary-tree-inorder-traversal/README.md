# Problem 1: Binary Tree Inorder Traversal

## 1. Problem
Given the root of a binary tree, return the values of its nodes using inorder traversal (Left -> Root -> Right).

## 2. Approach
I implemented a **Recursive Depth-First Search (DFS)** approach:
1. If the current node is `null`, return immediately (base case).
2. Recursively traverse the left subtree.
3. Add the current node's value to the result list.
4. Recursively traverse the right subtree.

### Written Tracing Example
Input tree: `1 -> right: 2 -> left: 3` (`[1, null, 2, 3]`)
- Start at `1`: traverse left (`null` -> returns).
- Visit `1`: `result = [1]`.
- Traverse right to `2`:
  - From `2`, traverse left to `3`:
    - From `3`, left is `null`, visit `3` -> `result = [1, 3]`, right is `null`.
  - Visit `2`: `result = [1, 3, 2]`.
  - From `2`, right is `null`.
- Final output: `[1, 3, 2]`.

### Challenges Faced
- **Iterative Stack Confusion**: Initially, I tried writing an iterative solution using a `Stack` without recursion, which caused duplicate node visits because I forgot to mark visited left children. Switching to a clean recursive helper function resolved the bug and made the traversal logic clear.

## 3. Time & Space Complexity
- **Time Complexity:** $O(n)$ — Every node in the tree is visited exactly once.
- **Space Complexity:** $O(h)$ — Auxiliary recursion stack space depends on the height $h$ of the tree ($O(\log n)$ for a balanced tree, $O(n)$ in the worst case for a skewed tree), excluding the output list.

## 4. Reflection / Improvement
- **Is there a more efficient approach?** Yes, **Morris Traversal** achieves $O(1)$ auxiliary space complexity.
- **What would need to change?** Instead of using recursion or a stack, temporarily link each node's inorder predecessor's right pointer back to the current node, then restore the tree structure while traversing.
