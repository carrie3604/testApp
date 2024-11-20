package Stack;

public class Stack
{

    private int[] elements = new int[2];
    private int size = 0;

    public boolean isEmpty()
    {
        return size == 0;

    }

    public void push(final int element)
    {
        this.elements[size++] = element;

    }

    public class Underflow extends RuntimeException
    {

    }

    public int pop()
    {
        if (isEmpty())
        {
            throw new Underflow();
        }
        return elements[--size];

    }
}
