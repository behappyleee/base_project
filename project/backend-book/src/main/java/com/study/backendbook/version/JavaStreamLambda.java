package com.study.backendbook.version;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaStreamLambda {

    public static void main(String[] args) {

        // Stream API 는 컬렉션에 추가 된 메서드의 집합을 의미
        // Stream 은 컬렉션에 담겨 있는 데이터를 마치 물이 흐르는 것처럼 처리한다는 것을 의미
        List<String> list = new ArrayList<String>();
        list.add("test");

        System.out.println(list.size());


        // for 문을 가져와서 list 요소를 가져올 수 있지만
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // Stream 을 사용하여 데이터를 조회할 수 있다.
        list.stream().forEach( str -> System.out.println("STR : " + str));

        Integer[] integers = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List<Integer> aa = Arrays.stream(integers).filter(num -> num % 2 != 0).toList();


    }
}
