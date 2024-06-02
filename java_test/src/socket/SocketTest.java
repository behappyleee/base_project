package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {

    private static final int PORT_NUMBER = 7733;

    public static void main(String[] args) {

        System.out.println("[::::: SOCKET START :::::]");

        try(ServerSocket server = new ServerSocket(PORT_NUMBER)) {
            while(true) {
                System.out.println("[::::: WHILE LOOP :::::]");
                System.out.println("[::::: FIRST SOCKET SERVER THREAD NANE  :::::]" + Thread.currentThread().getName());

                Socket connection = server.accept();
                Thread task = new SocketThreadServer(connection);
                System.out.println("[::::: SECOND SOCKET SERVER THREAD NANE  :::::]" + Thread.currentThread().getName());
                task.start();

                System.out.println("[::::: THIRD SOCKET SERVER THREAD NANE  :::::]" + Thread.currentThread().getName());
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
