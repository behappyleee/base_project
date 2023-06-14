import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleHTTPServer_2 {

    public static void main(String[] args) throws Exception {
        final ServerSocket serverSocket = new ServerSocket(8080);

        while(true) {
            // code 를 simple 하게 작성 하기 위하여 try-with-resource 를 사용
            // Socket 은 RESPONSE 를 끝내고 나면 자동으로 닫힐 것이다.

            // 문제는 서버 가 한번에 하나만 대응이 가능하다.
            // if request processing takes a longer time, which is not in our case, the other
            // connection has to wait. This problem can bo solved by using threads or Java Non IO-blocking selectors
            // and channels

            // Important thing is Server Socket is used to receive connections in the Server application and Socket
            // is used to send and receive data from the individual clients.

            try(Socket socket = serverSocket.accept();) {
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;

                // Clinet 에게 값을 RESPONSE 를 위하여 output stream 이 필요하다.
                // need to get the output stream from the socket.
                // and then we will write HTTP response code OK and today's
                // date into the stream.
                socket.getOutputStream()
                        .write(httpResponse.getBytes("UTF-8"));

            }
        }

    }

}
