package com.suri.leetcode.hard;

import com.suri.common.Pair;

import java.util.*;

/**

 Design a max stack data structure that supports the stack operations and supports finding the stack's maximum element.

 Implement the MaxStack class:

 MaxStack() Initializes the stack object.
 void push(int x) Pushes element x onto the stack.
 int pop() Removes the element on top of the stack and returns it.
 int top() Gets the element on the top of the stack without removing it.
 int peekMax() Retrieves the maximum element in the stack without removing it.
 int popMax() Retrieves the maximum element in the stack and removes it. If there is more than one maximum element, only remove the top-most one.
 You must come up with a solution that supports O(1) for each top call and O(logn) for each other call.



 Example 1:

 Input
 ["MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop", "top"]
 [[], [5], [1], [5], [], [], [], [], [], []]
 Output
 [null, null, null, null, 5, 5, 1, 5, 1, 5]

 Explanation
 MaxStack stk = new MaxStack();
 stk.push(5);   // [5] the top of the stack and the maximum number is 5.
 stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
 stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
 stk.top();     // return 5, [5, 1, 5] the stack did not change.
 stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
 stk.top();     // return 1, [5, 1] the stack did not change.
 stk.peekMax(); // return 5, [5, 1] the stack did not change.
 stk.pop();     // return 1, [5] the top of the stack and the max element is now 5.
 stk.top();     // return 5, [5] the stack did not change.

 https://leetcode.com/problems/max-stack/solutions/2577027/max-stack/

 */

public class Soln_716_Max_Stack {

    public static void main(String[] args) {

        MaxStack stk = new MaxStack();
        stk.push(5);   // [5] the top of the stack and the maximum number is 5.
        stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
        stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
        stk.top();     // return 5, [5, 1, 5] the stack did not change.
        stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
        stk.top();     // return 1, [5, 1] the stack did not change.
        stk.peekMax(); // return 5, [5, 1] the stack did not change.
        stk.pop();     // return 1, [5] the top of the stack and the max element is now 5.
        stk.top();     // return 5, [5] the stack did not change.

    }
}

class MaxStack {

    private Stack<Pair<Integer, Integer>> stack;
    private Queue<Pair<Integer, Integer> > heap;
    private Set<Integer> removed;
    private int cnt;



    public MaxStack() {
        stack = new Stack<>();
        heap= new PriorityQueue<>((a, b)-> b.getKey() - a.getKey()==0? b.getValue()-a.getValue(): b.getKey() - a.getKey());
        removed = new HashSet<>();

    }

    public void push(int x) {
        stack.add(new Pair(x, cnt));
        heap.add(new Pair(x, cnt));
        cnt++;
    }

    public int pop() {
        while(removed.contains(stack.peek().getValue())){
            stack.pop();
        }
        Pair<Integer, Integer> top = stack.pop();
        removed.add(top.getValue());
        return top.getKey();

    }

    public int top() {
        while(removed.contains(stack.peek().getValue())){
            stack.pop();
        }
        return stack.peek().getKey();

    }

    public int peekMax() {
        while(removed.contains(heap.peek().getValue())){
            heap.poll();
        }
        return heap.peek().getKey();

    }

    public int popMax() {
        while(removed.contains(heap.peek().getValue())){
            heap.poll();
        }

        Pair<Integer, Integer> top = heap.poll();
        removed.add(top.getValue());
        return top.getKey();
    }
}

/**
 Approach 2: Heap + Lazy Update
 Intuition
 To peek or pop the max element quickly, we may think of a heap (or priority queue). Meanwhile, a classic stack is sufficient to peek or pop the last added element quickly. What if we keep the two data structures at the same time?

 Yes, we can pop the max or the last element quickly. However, when we pop the top element of our heap or the stack, we don't know how to locate the removed element in the other one unless we enumerate all items in it from top to bottom.

 Thus, we are not urgent to delete the popped element. Instead, we just memorize the ID of this element. Next time, when we are going to peek or pop the top of our heap or stack, we first check whether the top is already removed from the other data structure by checking its ID.

 Algorithm
 To memorize all IDs of deleted elements, we use a hash set removed to store them. Apart from the stack(stack) and max heap(heap) we mentioned above, we still need a counter cnt like Approach 1 to tag each element with a unique ID.

 Whenever push(x) is called, we add it along with the current counter value into both heap and stack, then increase our cnt by 1.

 Whenever we are requested to operate on stack or heap (i.e., top, pop, peekMax and popMax), we first check the ID of its top element, if is turns out to be an ID in removed, that is, it was removed previously, we need to remove the current top element until its ID is not in removed to make sure the top still exists. After that,

 For top, return the value of the top element in stack.
 For peekMax, return the value of the top element in heap.
 For pop, remove the top element of stack, put its ID into removed, and return its value.
 For popMax, remove the top element of heap, put its ID into removed, and return its value.
 We can observe that we only check the existence of the top element and remove the element only when it is at the top because the deletion operation for the top of a stack or heap is much faster.

 */

/**

 Complexity Analysis
 Let N be the number of elements to add to the stack.

 Time Complexity:

 push: O(logN), it costs O(logN) to add an element to heap and O(1) to add an it to stack.
 The amortized time complexity of operations caused by a single pop/popMax call is O(logN). For a pop call, we first remove the last element in stack and add its ID to removed in O(1), and result in a deletion of the top element in heap in the future (when peekMax or popMax is called), which has a time complexity of logN. Similarly, popMax needs O(logN) immediately and O(1) in the operations later. Note that because we lazy-update the two data structures, future operations might never happen in some cases. But even in the worst cases, the upper bound of the amortized time complexity is still only O(logN).
 top: O(1), excluding the time cost related to popMax calls we discussed above.
 peekMax: O(logN), excluding the time cost related to pop calls we discussed above.
 Space Complexity: O(N), the maximum size of the heap, stack, and removed.

 */
