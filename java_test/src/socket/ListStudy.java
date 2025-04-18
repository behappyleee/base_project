package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ListStudy {

    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;

    public ListStudy(String ip, int port) {
        try {
            // 서버에 요청 보내기
            socket = new Socket(ip, port);
            System.out.println("[ " + socket.getInetAddress().getHostAddress() + " ..... 에 연결됨 ]");

            // 메시지 받기
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());

            // 메세지 전달
            pw.println("[SEND MESSAGE CHECK PLEASE ! .... ]");
            pw.flush();

            // 응답 출력
            System.out.println("[RESPONSE FROM SERVER .... ] " + br.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // 소켓 닫기 (연결 끊기)
            try {
                if(socket != null) socket.close();
                if(br != null) br.close();
                if(pw != null) pw.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
