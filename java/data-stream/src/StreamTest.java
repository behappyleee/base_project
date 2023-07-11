import java.util.Arrays;

public class StreamTest {

    public static void main(String[] args) {
        Double [] doubleArray = {2.0, 3.0, 7.0, 3.5, 7.7, 7.4, 7.2};

        Arrays.stream(doubleArray).iterator(elem-> System.out::println);


    }

}
