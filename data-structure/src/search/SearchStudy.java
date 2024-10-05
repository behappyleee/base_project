package search;

import java.util.Arrays;

public class SearchStudy {

    public static void main(String[] args) {

        // 검색 - 데이터 집합에서 원하는 값을 가진 요소를 찾아내는 방법
        // 선형 검색 (linear search)
        // 요소가 직선 모양으로 늘어나있을 때 원하는 키 값을 갖는 요소를 만날 때 까지 맨 앞부터 순서대로 검색
        // 배열의 요소수가 n 개 일 때 판단하는 횟수는 평군 n / 2 회

        // 이진 검색
        // 해시법

        int[] aa = new int[]{1,1,1,1};

        Arrays.stream(aa).forEach(System.out::println);
        System.out.println(aa.length);

    }
}
