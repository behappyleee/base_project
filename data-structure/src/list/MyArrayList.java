package list;

import java.util.Arrays;
import java.util.Objects;

// TODO : ArrayList 구현 하기
public class MyArrayList<T> implements MyListInterface<T> {

    private T [] nodeList;

    public MyArrayList() {
        nodeList = (T[]) new Object[10];
    }

    public MyArrayList(int capacity) {
        nodeList = (T[]) new Object[capacity];
    }

    public static void main(String[] args) {
        MyArrayList<String> myArr = new MyArrayList<String>();
        myArr.add("A");
        myArr.add("B");
        myArr.add("C");

        int sizeCheck = myArr.getArraySize();

        System.out.println("SIZE CHECK : " + sizeCheck);
        System.out.println(myArr);
        System.out.println(myArr.toString());
    }

    @Override
    public int add(final T addData) {
        Objects.requireNonNull(addData);
        // TODO : 변수명 다시 고민해보기 사이즈 확인 하면서 && 사이즈 작으면 늘려주는 로직으로 !
        checkListSize();
        int nodeIndex = 0;
        while(true) {
            if (nodeList[nodeIndex] == null) {
                nodeList[nodeIndex] = addData;
                return nodeIndex;
            }
            nodeIndex++;
        }
    }

    @Override
    public T getByIndex(final int index) {
        checkIsProperIndexOrThrow(index);
        return nodeList[index];
    }

    @Override
    public int deleteByIndex(final int index) {
        checkIsProperIndexOrThrow(index);
        nodeList[index] = null;

        for (int deleteIndex = index; deleteIndex < nodeList.length; deleteIndex++) {
            nodeList[deleteIndex] = nodeList[deleteIndex + 1];
        }

        return index;
    }

    // TODO : Null 인 것은 사이즈에서 제외 시키기 !
    public int getArraySize() {
        return nodeList.length;
    }

    private void checkIsProperIndexOrThrow(int index) {
        if (index < 0 || index >= nodeList.length) {
            throw new IllegalArgumentException("It is not proper index to search.");
        }
    }


    private void checkListSize() {
        if (nodeList[nodeList.length - 1] != null) {
            T[] newBigArray = (T[]) new Object[nodeList.length + 10];

            int startIndex = 0;
            // copy to New Array
            while(startIndex < nodeList.length) {
                newBigArray[startIndex] = nodeList[startIndex];
                startIndex++;
            }

            nodeList = newBigArray;
        }
    }

    // TODO - null 처리 하기 !
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (int i=0; i<nodeList.length; i++) {
            stringBuilder.append(nodeList[i]);
            if (i != nodeList.length - 1) {
                stringBuilder.append(",");
            }
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
