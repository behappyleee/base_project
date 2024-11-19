package stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

public class InputStreamTest {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        InputStream inputStream = new FileInputStream("/Users/Desktop/testInput.txt");
        int readByte = 0;

        while ((readByte = inputStream.read()) != -1) {}


        long endTime = System.currentTimeMillis();
        System.out.println("소요시간 ms : " + (endTime - startTime));
    }
}
