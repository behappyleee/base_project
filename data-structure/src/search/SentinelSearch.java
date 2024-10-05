package search;

public class SentinelSearch {

    public static int seqSearch(int[] intArr, int findNum) {
        int i = 0;
        // 검색할 값을 보초로 대입,
        intArr[intArr.length - 1] = findNum;

        // 따라서 반복 종료에 대한 판단 횟수는 실제로 절반으로 줄어들게 됨 !
        // 종료 조건 1 -> if (i == n) ---> 하지만 보초 값을 사용 시 종료 조건 1이 필요 없어지게 됨 !
        // 종료 조건 2 -> a[i] == key -> 값 검색을 성공

        while (true) {
            // 검색 성공
            if (intArr[i] == findNum) {
                break;
            }
            i++;
        }

        return i == (intArr.length - 1) ? -1 : i;
    }

    public static void main(String[] args) {
        // 보초법 - 검색하기 전에 검색 하고자 하는 키 값을 맨 끝에 요소에 저장을 하며, 이때 저장 하는 값을 보초라고 합니다.
        // 보초법을 사용하면 종료 판단 횟수를 2회에서 1회로 줄이는 역할을 해 줌
        final int FIND_NUM = 2;

        // 보초 값 추가를 위하여 처음부터 +1 만큼 Array 공간을 잡는다.
        int[] intArr = new int[3];
        intArr[0] = 1;
        intArr[1] = 2;

        int findIndex = seqSearch(intArr, FIND_NUM);

        System.out.println("FIND NUMBER COMPARE : " + (intArr[0] == findIndex));
    }
}
