package search;

import java.util.Arrays;

public class BinarySearchStudy {

    static int binarySearch(int[] arr, int key) {
        int pl = 0;
        int pr = arr.length - 1;

        do {
            int pc = (pl + pr) / 2;

            if (arr[pc] == key) {
                return pc;
            // 찾은 중간값의 요소가 작은 경우
            } else if (arr[pc] < key) {
                pl = pc + 1; // 검색 범위를 뒤 쪽 절반으로 좁힘

            // 찾은 중간 값의 요소가 작은 경우
            } else {
                pr = pc - 1; // 검색 범위를 앞 쪽 절반으로 좁힘
            }
        } while(pl <= pr);

        // 검색 실패 찾는 값이 없음  !!
        return -1;
    }

    public static void main(String[] args) {
        // 이진 검색 - 해당 알고리즘을 적용하는 전제 조건은 데이터가 key 값으로 이미 정렬 되어 있는 상태여야 함
        // 이진 검색은 선형 검색보다 조금 더 빠르게 검색할 수 있다는 장점이 있음
        // 이전 검색은 요소가 오름차순 또는 내림차순 으로 정렬 된 배열에서 검색하는 알고리즘

        // pl - 요소 맨 첫번째, pc - 요소 중간 (n-1/2), pr - 요소 맨 끝

        // 이진 검색 알고리즘 종료 조건
        // 1 - a[pc] 와 key 가 일치하는 경우
        // 2- 검색 범위가 더 이상 없는 경우

        // 반드시 오름 차순이여야 함 !
        final int FIND_NUM = 4;
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int findIndex = binarySearch(arr, FIND_NUM);

        System.out.println("FIND NUMBER COMPARE : " + (arr[findIndex] == FIND_NUM));
        System.out.println("FIND VALUE CHECK : " + arr[findIndex]);
    }
}
