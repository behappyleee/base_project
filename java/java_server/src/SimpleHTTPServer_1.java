import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHTTPServer_1 {

    public static void main(String[] args) throws Exception {
        // Listening 8080 port ServerSocket 생성
        // 우리 서버는 Port 8080 에 Connection 을 기다리고 있다.
        final ServerSocket serverSocket = new ServerSocket(8080);

        // Acception Connection
        System.out.println("Listening for connection on port 8080 ....");

        // can accept incoming connection by blocking call to accept() method
        // Blocking Method - Block the executing thread until their operation is finished.
        // (A famous example of the blocking method is the InputStream read() method which blocks until
        // all data from InputStream has been read completely.

        // A correct understanding of blocking methods is required, because if not used carefully blcking method can freeze.
        // GUIs, hung your program.

        // Blocking - Code in the next line will not be executed because the Thread which is executing the blocking function is waiting
        // for the method to return.

        while(true) {
            // 1. Read HTTP request from the client socket.
            // 2. Prepare an HTTP Response.
            // 3. Send HTTP Response to the client.
            // 4. Close the socket.

            final Socket clientSocket = serverSocket.accept();

            // This is the standard HTTP Server. its simple because HTTP is stateless.
            // which means it doesn't need to remember the previous connection.
            // all it cares for new incoming connections.

            // InputStreamReadr 는 blocking function 만약 read 해주지 않으면 안 끝남 (return 만을 기다림)
            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);

            String line = reader.readLine();
            while(!line.isEmpty()) {
                System.out.println(line);
                line = reader.readLine();
            }

        }

    }

}
