package search;


public class LinearSearch {

    // 요소수가 n 인 배열 a 에서 key 와 같은 요소를 찾는다.
    // 메서드 seqSearch 는 배열 a 의 처음부터 끝까지 n 개의 요소를 대상으로 값이 key 인 요소를 선형 검색하고 요소의 인덱스를 반환
    public static int seqSearch(int[] a, int key) {
        int i = 0;

        while(true) {
            if (i ==  a.length) {
                return -1;
            }

            if (a[i] == key) {
                return i;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        final int FIND_NUM = 3;

        int[] intArr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int findSeq = seqSearch(intArr, FIND_NUM);

        System.out.println("선형 검색 결과 : " + (intArr[findSeq] == FIND_NUM));
        System.out.println("findSeq = " + findSeq);
    }
}
