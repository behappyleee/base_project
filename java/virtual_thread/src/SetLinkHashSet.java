import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetLinkHashSet {

    public static void main(String[] args) {
        // Set 종류
        // HashSet / TreeSet / LinkedHashSet

        // HashSet - Hashing 을 이용하여 구현한 컬렉션 데이터를 중복 저장할 수 없고 순서를 보장하지 않음
        // equals() 나 hashCode() 를 오버라이딩해서 인스턴스가 달라도 동일 객체를 구분해 중복 저장을 막을 수 있다.

        // TreeSet - 이진 탐색 트리 (Red-Black-Truee) 의 형태로 데이터를 저장, 데이터 추가 삭제에는 시간이 더 걸리지만
        // 검색과 정렬이 더 뛰어나며 기본적으로 오름차순으로 데이터를 정렬

        // LinkedHashSet - HashSet 클래스를 상속받은 LinkedList, 데이터에 삽입 된 순서대로 데이터를 관리

        Set <String> set = new HashSet<String>();
        Set <String> setLink = new LinkedHashSet<String>();

        set.add("a");
        setLink.add("a");



    }

}
