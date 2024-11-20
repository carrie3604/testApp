package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Stack.Stack.Underflow;

public class StackTest
{
    @Autowired
    private Stack stack;

    @BeforeEach
    void setUp()
    {
        stack = new Stack();
    }

    @Test
    public void newStack_isEmpty()
    {
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    public void afterOnePush_isNotEmpty()
    {
        stack.push(0);
        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    public void throwUnderflow_afterPopWhenIsEmpty()
    {

        Assertions.assertThrows(Underflow.class, () ->
        {
            stack.pop();
        });

    }

    @Test
    public void afterOnePushAndOnePop_isEmpty()
    {
        stack.push(0);
        stack.pop();
        Assertions.assertTrue(stack.isEmpty());

    }

    @Test
    public void afterTwoPushesAndOnePop_isNotEmpty()
    {
        stack.push(0);
        stack.push(0);
        stack.pop();
        Assertions.assertFalse(stack.isEmpty());

    }

    @Test
    public void afterPushX_willPopX()
    {
        stack.push(99);
        Assertions.assertEquals(99, stack.pop());
        stack.push(88);
        Assertions.assertEquals(88, stack.pop());

    }

    @Test
    public void afterPushXAndY_willPopYThenX()
    {
        stack.push(99);
        stack.push(88);
        Assertions.assertEquals(99, stack.pop());

        Assertions.assertEquals(88, stack.pop());
        Assertions.assertFalse(stack.isEmpty());

    }
}
