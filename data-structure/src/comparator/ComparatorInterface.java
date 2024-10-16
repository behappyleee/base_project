package comparator;

public interface ComparatorInterface<T> {
    int compare(T o1, T o2);

    boolean equals(T o1, T o2);
}
