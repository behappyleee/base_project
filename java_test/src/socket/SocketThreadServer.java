package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketThreadServer extends Thread {

    // Java Socket 통신
    private Socket socket;

    public SocketThreadServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // BufferedReader 와 PrintWriter 객체를 생성
        BufferedReader br = null; // 읽는 객체
        PrintWriter pw = null;    // 쓰는 객체

        try {
            String connIp = socket.getInetAddress().getHostAddress();
            System.out.println("[해당 IP 에서 연결을 시도 ....] : " + connIp);

            // 접근 한 소켓 계정의 ip 를 체크
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());

            // Client 측에서 보낸 문자열을 출력
            System.out.println("[MESSAGE FROM CLIENT SIDE ... ] : " + br.readLine());

            pw.println("[RECEIVED OK ....]");
            pw.flush();
        } catch (IOException exception) {
            System.out.println("IOException: " + exception.getMessage());
        } finally {
            try {
                if(pw != null) pw.close();
                if(br != null) br.close();
                if(socket != null) socket.close();
            } catch(IOException e) {
                System.out.println("IOException: " + e.getMessage());
            }
        }
    }
}
