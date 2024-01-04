package com.sample.study.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericWildCard {

    public static void main(String[] args) {
        // Generic 은 코드의 재 사용성을 높이고 데이터 타입의 안정성을 높여줌
        // 제네릭이 없었더라면 객체를 담는 컬렉션을 안전하게 사용이 불가

        // String 타입의 값을 상위 Object 타입 변수에 넣을 수 있음
        // String 은 Object 의 하위 타입이라 가능
        String aa = "yaho";
        Object bb = aa;

        List<String> stringList = new ArrayList<>();
        // List<Object> objectList = stringList;    // 이것은 불가능 함, 에러가 발생

        // Type Parameter 간에는 상/하위 관계가 없고 raw-type 에서만 상-하위 관계가 존재

        Collection<String> c = new ArrayList<>();
        c.add("hi");
        c.add("hlelo");

        // 만약 Collection<Object> 이면 Type 오류로 컴파일이 안 됨, 오류가 발생

        printCollection(c);

        List<String> strList = new ArrayList<>();
        List<?> ccc = strList;  // ? 로 지정 시 에러가 발생하지 안흥ㅁ
        strList.add("asdad");
        strList.add("sdasdasd");

        ccc.get(0);

    }

    // public static void printCollection(Collection<Object> c) {
     public static void printCollection(Collection<?> c) {  // 위 처럼 Object 가 아닌 ? 와일드 카드로 지정 해주어야 함
        for(Object e: c) {
            System.out.println(e);
        }
    }


}
