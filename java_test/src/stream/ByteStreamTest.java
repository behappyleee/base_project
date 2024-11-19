package stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteStreamTest {

    public static void main(String[] args) {

        byte[] intArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outArr = null;

        ByteArrayInputStream in = new ByteArrayInputStream(intArr);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        in.read();

    }
}
