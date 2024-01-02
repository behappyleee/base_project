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

public class HTTPPerformance {

    // HTTP 서버 구축 하기
    // private static final String INPUT_FILE = "C:\\Users\\Chul Han\\Desktop\\workspace\\study\\base_project\\java\\multi_thread\\resources\\war_and_peace.txt";

    private static final String INPUT_FILE = "resources/war_and_peace.txt";

    private static final int NUMBER_OF_THREADS = 1;

    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
        startServer(text);
        System.out.println(text);

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

            if (!action.equals("word")) {
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

    }

}
