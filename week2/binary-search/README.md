# Binary Search

## 1. Problem

The task is to find the index of a target value in a sorted array.

If the target exists in the array, we return its index. If the target does not exist, we return `-1`.

## 2. Approach

I started with a simple linear search.

The algorithm checks each element of the array one by one, starting from the first element.

For every element, I compare it with the target.

If the current element is equal to the target, I return its index.

If the target is not found after checking all elements, I return `-1`.

This solution is simple, but it does not use the fact that the array is sorted.

## 3. Time Complexity

**Time Complexity: O(n)**

In the worst case, the target is the last element of the array or the target is not present.

In this case, the algorithm checks all `n` elements.

Therefore, the number of operations grows linearly with the size of the array, so the time complexity is **O(n)**.

## 4. Space Complexity

**Space Complexity: O(1)**

The algorithm does not create any additional data structures.

It only uses the loop variable `i`, so the amount of additional memory does not depend on the size of the input.

Therefore, the space complexity is **O(1)**.

## 5. Reflection / Improvement

There is a more efficient approach because the array is sorted.

I could use binary search instead of checking every element.

Binary search checks the middle element of the current search range. Depending on the comparison with the target, I can eliminate half of the remaining elements.

The improved solution would have:

**Time Complexity: O(log n)**

**Space Complexity: O(1)**

The main improvement is using the sorted property of the array.
