package tree;

import java.util.Comparator;

public class NodeTest {

    public static void main(String[] args) {

    }

    static class NodeCheck<K, V> {
        K key;
        V data;
        NodeCheck<K, V> left;
        NodeCheck<K, V> right;

        NodeCheck(K key, V data, NodeCheck<K, V> left, NodeCheck<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return data;
        }

        void print() {
            System.out.println(data);
        }

        // TODO - 공부가 필요 .... !!
        private NodeCheck<K, V> root; // root
        private Comparator<? super K> comparators = null;
    }
}
