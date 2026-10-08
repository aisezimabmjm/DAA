# Intersection of Two Linked Lists

## 1. Problem
Given the heads of two singly linked lists `headA` and `headB`, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return `null`.

## 2. Approach
I used a two-pointer technique to equalize the traversal distances:
1. Initialize pointer `pA` at `headA` and `pB` at `headB`.
2. Advance both pointers one step at a time.
3. When `pA` reaches the end of list A (`null`), redirect it to `headB`.
4. When `pB` reaches the end of list B (`null`), redirect it to `headA`.
5. If the lists intersect, `pA` and `pB` will meet at the intersection node after at most $N + M$ steps. If they do not intersect, both will reach `null` simultaneously.

### Step-by-Step Tracing Example
Input: List A = `[4, 1, 8, 4, 5]`, List B = `[5, 6, 1, 8, 4, 5]` (Intersect at node `8`)

- **Length A = 5, Length B = 6**. Total distance traversed by each pointer before meeting: $5 + 6 = 11$ nodes.
- **Step 1-5:** `pA` moves through A, `pB` moves through B.
- **Step 6:** `pA` reaches `null` and jumps to `headB`. `pB` reaches node `5` of B.
- **Step 7:** `pB` reaches `null` and jumps to `headA`.
- **Step 8-10:** Both pointers advance along the remaining paths.
- **Step 11:** Both `pA` and `pB` point to node `8`. Loop terminates (`pA == pB`).
- **Result:** Node `8`.

### Challenges Faced
- **Nested Loops Approach ($O(N \times M)$):** Brute-force comparison of every node in A with every node in B was too slow for large inputs.
- **HashSet Approach ($O(N)$ space):** Storing nodes of List A in a Set works in $O(N)$ time, but uses $O(N)$ extra memory. The two-pointer redirection trick allowed achieving $O(1)$ space without calculating list lengths manually.

## 3. Complexity Analysis

* **Time Complexity:** $O(N + M)$
  - **Reason:** Pointer `pA` traverses List A then List B, while pointer `pB` traverses List B then List A. Both pointers travel a combined length of at most $N + M$ steps.

* **Space Complexity:** $O(1)$
  - **Reason:** Only two pointer variables (`pA`, `pB`) are created.

## 4. Reflection / Improvement
- **Alternative Approach:** Calculate the length of both lists first, advance the pointer of the longer list by the difference in lengths, then traverse together. This also runs in $O(N + M)$ time and $O(1)$ space, but requires slightly more boilerplate code.
