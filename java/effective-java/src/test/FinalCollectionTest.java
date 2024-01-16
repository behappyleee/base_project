package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinalCollectionTest {

    public static void main(String[] args) {
        // Java 에서는 final 로 선언 하여도 Collection 이 변경이 가능
        final List<String> finalList = new ArrayList<>();
        finalList.add("Test1");
        finalList.add("Test2");

    }

}
