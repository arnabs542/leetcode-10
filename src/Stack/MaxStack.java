package Stack;

import java.util.Stack;

/**
 *
 * Design a max stack that supports push, pop, top, peekMax and popMax.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Remove the element on top of the stack and return it.
 * top() -- Get the element on the top.
 * peekMax() -- Retrieve the maximum element in the stack.
 * popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
 * Example 1:
 * MaxStack stack = new MaxStack();
 * stack.push(5);
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 * Note:
 * -1e7 <= x <= 1e7
 * Number of operations won't exceed 10000.
 * The last four operations won't be called when stack is empty.
 *
 */

// 用treemap

public class MaxStack {

    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty()) {
            maxStack.push(x);
            return;
        }
        maxStack.push(x > maxStack.peek() ? x : maxStack.peek());
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int peekTop = stack.peek();
        int maxElement = maxStack.peek();
        if (peekTop != maxElement) {
            Stack<Integer> tempStack = new Stack<>();
            while (!stack.isEmpty() && stack.peek() != maxElement) {
                maxStack.pop();
                tempStack.push(stack.pop());
            }
            stack.pop();                                // 这里千万别忘记要pop这两个东西
            maxStack.pop();
            while (!tempStack.isEmpty()) {
                this.push(tempStack.pop());
            }
            return maxElement;

        } else {
            stack.pop();
            return maxStack.pop();
        }
    }
}
