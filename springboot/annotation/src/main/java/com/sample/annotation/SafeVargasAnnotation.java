package com.sample.annotation;

import java.util.Arrays;
import java.util.List;

public class SafeVargasAnnotation {

    /**
     * @SafeVargas
     *
     * Vargas 는 Arguments 들을 동적으로 받아줄 수 있도록 가능하게 해준다.
     * Java 5 전에는 Argument 를 오직 추가하기 위하여서는 Method 를 여러개 만드는 방법뿐이 없었다.
     *
     * Vargas 는 단 메서드 하나 만 으로 다양한 Parameter 들을 다룰 수 있게 해준다.
     *
     * */

    public static void main(String[] args) {
        // Vargas 덕분에 Argument 갯수 상관없이 Parameter 를 받을 수 있음
        List<String> str1 = Arrays.asList("a", "b", "c");
        List<String> str2 = Arrays.asList("1", "2", "3", "4");


        vargasList(str1, str2);


    }
    // List 도 generic 을 사용 하기에 Warning 이 발생한다.
    // SafeVargas 어노테이션 사용 시 경고를 무시할 수 있다.
    @SafeVarargs
    public static void vargasList(List<String>... lists) {
        for(List<String> subList : lists) {
            for(String str : subList) {
                System.out.println("THIS IS SUB LIST STRING : " + str);
            }
        }
    }

    // Vargas 사용
    public static void vargasMethod(String ...vargasParameter) {
        for(String param : vargasParameter) {
            System.out.println("VARGAS METHOD PARAM : " + param);
        }
    }

    public static void originMethod(String a, String b) {
        System.out.println("A : " + a + " B : " + b);
    }


}
