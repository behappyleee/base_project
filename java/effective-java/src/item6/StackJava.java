package item6;

import java.util.Arrays;
import java.util.Comparator;

public class StackJava {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INIITIAL_CAPACITY = 10;

    public StackJava() {
        elements = new Object[DEFAULT_INIITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object popWrong() {
        if(size == 0)
            throw new EmptyStackException();
        // TODO : Wrong 인 이유는 pop 을 시켜주었으면 null 로 초기화를 시켜주어야 함!
        return elements[--size];
    }

    // Corrected version of pop method
    public Object popCorrect() {
        if(size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;  // Eliminate obsolete reference
        return result;
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

    public static void main(final String[] args) {
//        int index = 0;
//        String[] strArr = new String[10];
//        strArr[index++] = "T1";
//        strArr[index++] = "T2";
//        System.out.println("STR ARR LENGTH : " + strArr.length);
//        System.out.println("STR ARR INDEX : " + index);
//        System.out.println("STR INDEX ARR : " + strArr[2]);

        StackJava stack = new StackJava();
        for(String arg: args) {
            stack.push(arg);
        }

        while(true) {
            System.err.println(stack.popWrong());
        }
    }

    // Study
    // TODO : comparator 와 comparable 차이점 공부 하기 !!

    // Comparator.naturalOrder();
    // Comparator<String>()
    // Comparable
    // Comparator




}
