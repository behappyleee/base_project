package generic;

public class CollectionTest {

    public static void main(String[] args) {

        // Generice 을 사용하지 않은 Collection 을 사용
        SimpleCollection sc = new SimpleCollection();
        sc.add("123");
        sc.add(2566);
        sc.add(2323);
        sc.add("hello");
        sc.add("world");

        // 만약 Generic 을 사용하지 않는다면 Runtime Exception 에러가 발생
//        int aTest = (Integer)sc.get(0);
//
//        // Generice 을 타입을 지정 해주었으므로 Integer 만 사용이 가능 !
//        SimpleCollectionGeneric<Integer> sc1 = new SimpleCollectionGeneric<>();
//        sc1.add(2323);
//        sc1.add(213213);

    }

}

class SimpleCollectionGeneric<T> {

    private final int MAX_COLLECTION_SIZE = 100;
    private final Object[] data = new Object[MAX_COLLECTION_SIZE];
    private int HEAD = 0;

    void add(T object) {
        data[HEAD] = object;
        HEAD++;
    }

    T get(int index) {
        return (T)data[index];
    }

}

class SimpleCollection {

    private final int MAX_COLLECTION_SIZE = 100;
    private final Object[] data = new Object[MAX_COLLECTION_SIZE];
    private int HEAD = 0;

    void add(Object object) {
        data[HEAD] = object;
        HEAD++;
    }

    Object get(int index) {
        return data[index];
    }

}
