package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinStackTest {

    @Test
    public void testPushAndGetMin() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        assertEquals(-3, stack.getMin(), "getMin() should return -3 after pushing [-2, 0, -3]");
    }

    @Test
    public void testPopAndGetMin() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        stack.pop();
        assertEquals(-2, stack.getMin(), "getMin() should return -2 after popping -3");
    }

    @Test
    public void testTop() {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(10);
        assertEquals(10, stack.top(), "top() should return 10");
        stack.pop();
        assertEquals(5, stack.top(), "top() should return 5 after popping 10");
    }

    @Test
    public void testGetMinWithSingleElement() {
        MinStack stack = new MinStack();
        stack.push(1);
        assertEquals(1, stack.getMin(), "getMin() should return 1 when there is only one element");
    }

    @Test
    public void testPopOnEmptyStack() {
        MinStack stack = new MinStack();
        stack.pop();  // Should not throw an error
        assertEquals(-1, stack.getMin(), "getMin() should return -1 for an empty stack");
        assertEquals(-1, stack.top(), "top() should return -1 for an empty stack");
    }

    @Test
    public void testPushDuplicateMinValues() {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(2);
        stack.push(1);
        stack.push(1);
        assertEquals(1, stack.getMin(), "getMin() should return 1");

        stack.pop();
        assertEquals(1, stack.getMin(), "getMin() should still return 1 after popping one occurrence");

        stack.pop();
        assertEquals(2, stack.getMin(), "getMin() should return 2 after removing all occurrences of 1");
    }

    @Test
    public void testPopUntilEmpty() {
        MinStack stack = new MinStack();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        assertEquals(1, stack.getMin());

        stack.pop();
        assertEquals(2, stack.getMin());

        stack.pop();
        assertEquals(3, stack.getMin());

        stack.pop();
        assertEquals(-1, stack.getMin(), "getMin() should return -1 when stack is empty");
    }
}
