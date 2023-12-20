package item6;

import java.util.Arrays;

public class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INIITIAL_CAPACITY = 10;

    public Stack() {
        elements = new Object[DEFAULT_INIITIAL_CAPACITY];
    }

    public void push(Object e) {

    }

    public Object pop() {
        if(size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    /**
    *   Empty space for at least one more element, roughly
     *   doubling the capacity each time the array needs to grow.
    * */
    private void ensureCapacity() {
        if(elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size -1);
        }
    }

    


}
