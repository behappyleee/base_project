package kafka;

import java.io.*;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class TestCheckClass {

    public int testInt = 3;
    private String testString = "testString";

    public static void main(String[] args) {
        String a = "";
        char b = '\u0000';

        System.out.println("PRINT TEST : " + b);

//        try (FileSystem jrt = FileSystems.newFileSystem(URI.create("jrt:/"), Map.of())) {
//            Path p = jrt.getPath("/modules/java.base/lib/tzdb.dat");
//            byte[] bytes = Files.readAllBytes(p);
//            System.out.println("tzdb.dat size = " + bytes.length); // 여기가 0이 아니어야 정상
//        }
    }
}





