package katas.exercises;

import org.junit.jupiter.api.Test;

import static katas.exercises.ValidParentheses.isValidParentheses;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class isValidParenthesesTest {

    @Test
    public void isValid1() {
        String validInput = "()[]{}";
        assertTrue(isValidParentheses(validInput));
    }

    @Test
    public void isValid2() {
        String validInput = "{[()]}";
        assertTrue(isValidParentheses(validInput));
    }

    @Test
    public void isValid3() {
        String validInput = "([])";
        assertTrue(isValidParentheses(validInput));
    }

    @Test
    public void isValid4() {
        String validInput = "([]";
        assertFalse(isValidParentheses(validInput));
    }
}
