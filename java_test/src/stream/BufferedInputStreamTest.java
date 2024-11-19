package stream;

import java.io.*;

public class BufferedInputStreamTest {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        InputStream inputStream = new FileInputStream("/Users/chulhanlee/Desktop/testInput.txt");
        BufferedInputStream bis = new BufferedInputStream(inputStream);

        while (bis.read() != -1) {}

        long endTime = System.currentTimeMillis();
        System.out.println("소요시간 ms : " + (endTime - startTime));
    }
}

