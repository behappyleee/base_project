package com.study.backendbook.version;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaJavaVersion {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        list.add("public");
        list.add("static");
        list.add("void");

        // Lambda 사용하지 않았을 때
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        // 람다 사용 하였을 때
        // 훨씬 간결 해 짐
        list.sort((Comparator<String>) (str1, str2) -> str1.compareTo(str2));




    }
}
