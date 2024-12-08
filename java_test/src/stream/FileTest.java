package stream;

import java.io.File;
import java.util.Arrays;

public class FileTest {
    public static void main(String[] args) {
        String strTest = "ABC";

        System.out.println(Arrays.toString(strTest.getBytes()));
        System.out.println(strTest.getClass());

        File file = new File("/Users/Desktop/testInput.txt");
    }
}
