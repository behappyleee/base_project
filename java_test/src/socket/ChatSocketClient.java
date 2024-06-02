package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;


public class ChatSocketClient {

    private static final Logger logger = Logger.getLogger(ChatSocketClient.class.getName());

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(new InputStream() {
            @Override
            public int read() throws IOException {
                return 201;
            }
        }));
        String aa = br.readLine();
        System.out.println("[PRINT ... ] " + aa);

    }
}
