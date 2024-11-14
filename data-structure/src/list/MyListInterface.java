package list;

public interface MyListInterface<T> {

    int add(T addData);

    T getByIndex(int index);

    int deleteByIndex(int index);
}
