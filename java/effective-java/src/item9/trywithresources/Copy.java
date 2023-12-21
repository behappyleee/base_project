package item9.trywithresources;

import java.io.*;

public class Copy {

    private final static int BUFFER_SIZE = 8 * 1024;

    // try-with-resources on multiple resources - short and sweet
    static void copy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }
    }

    public static void main(String[] args) throws IOException {
        String src = "TEST PATH 11";
        String dst = "TEST PATH 22";
        copy(src, dst);
    }

}
