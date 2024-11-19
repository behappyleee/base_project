package stream;

import java.io.*;

public class BufferedReaderTest {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        // InputStream 은 byte 기반 스트림임, 바이트 기반이라 하면은 입출력 단위가 1 byte 임
        // 문자 데이터를 입출력 할 때 는 바이트 기반 스트림 대신 문자 기반 스트림을 사용

        InputStream ipTest = new FileInputStream("/Users/chulhanlee/Desktop/testInput.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(ipTest));
        String line;

    //        while (ipTest.read() != -1) {}

        while((line = br.readLine()) != null) {
    //        System.out.println(line);
        }
        long endTime = System.currentTimeMillis();

        // 해당 성능 차이가 발생
        // BufferedReader 사용 시 : 약 195 ms
        // InputStream 만 사용 시 : 약 57320 ms

            System.out.println("소요시간 ms : " + (endTime - startTime));
    }
}
