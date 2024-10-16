package comparator;

public class ComparatorImpl {

    private static final ComparatorInterface<String> COMPARATOR = new Compare();

    private static class Compare implements ComparatorInterface<String> {

        @Override
        public int compare(String o1, String o2) {

            return 1;
        }

        @Override
        public boolean equals(String  a, String b) {


            return false;
        }

    }
}
