package thread.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class HTTPPerformance {

    // 성능 측정을 위하여 Apache Jmemter 를 사용
    // HTTP 서버 구축 하기
    // private static final String INPUT_FILE = "C:\\Users\\Chul Han\\Desktop\\workspace\\study\\base_project\\java\\multi_thread\\resources\\war_and_peace.txt";

    private static final String INPUT_FILE = "resources/war_and_peace.txt";

    // THREAD POOL 1 로 설정 시 최대 초당 처리 갯수 1015.5 / sec
    // THREAD POOL 2 로 설정 1431.7 / sec 어플리케이션에 THREAD 를 추가 시 처리 갯수가 거의 배 가 늘어 남
    // 물리 코어 갯수 까지 THREAD 를 늘리면 처리량이 급속도로 늘어남, 논리 가상 코어 까지 늘릴 시 많이 늘어나지는 않지만 완만히 늘어남
    // 가상 코어 수 이상으로 늘리면 어떻게해도 처리량이 늘어나지 않음

    // Application 에 할당한 적절한 스레드 수를 학습, 최고의 전략으로 서로 다른 스레드에 들어오는 모든 요청을 처리
    // 발생할 수 밖에 없는 오버헤드를 최소화 함

    private static final int NUMBER_OF_THREADS = 2;

    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
        startServer(text);
    }

    // HTTP Server 구축 하기
    public static void startServer(String text) throws IOException {
        // HttpServer.create 메서드를 사용하여 HTTP 서버를 생성
        // 두번쨰 변수는 백로그 크기로 HTTP 서버 요청에 맞는 대기열 크기를 정의, 0 으로 유지
        // 모든 요청이 스레드 풀 대기열에 들어가야 함
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        // HTTP 응답을 전송
        server.createContext("/search", new WordCountHandler(text));
        Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        server.setExecutor(executor);
        //
        // HTTP 서버가 start 로 하면 Port 애플리케이션이 8000 번으로 들어오는 HTTP 요청을 Listening 함
        // 검색 라우트에 속한 들어오는 모든 요청은 WordCountHandler 가 처리하고 FixedThredaPool 의 스레드 중 하나에서 실행이 됨
        server.start();

        System.out.println("[Starting Server .....]");
    }

    public static class WordCountHandler implements HttpHandler {

        private String text;
        public WordCountHandler(String text) {
            this.text = text;
        }

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String query = httpExchange.getRequestURI().getQuery();
            String [] keyValue = query.split("=");

            String action = keyValue[0];
            String word = keyValue[1];

            if (!action.equals("WORD")) {
                httpExchange.sendResponseHeaders(400 ,0);
                return;
            }

            long count = countWord(word);
            // 직렬화 하여 전송
            byte[] response = Long.toString(count).getBytes();
            httpExchange.sendResponseHeaders(200, response.length);
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(response);
            outputStream.close();
        }

        private long countWord(String word) {
            long count = 0;
            int index = 0;
            while(index >= 0) {
                // 인덱스가 양수로 나오면 성송적으로 단어를 찾음
                index = text.indexOf(word, index);
                if (index >= 0){
                    // 단어가 존재하므로 count 와 index 를 늘려줌
                    count++;
                    index++;
                }
            }
            // loop 를 빠져나와 count 를 반환
            return count;
        }
    }

}
