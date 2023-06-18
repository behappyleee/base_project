package lox;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Lox {
    public static void main(String[] args) throws IOException {
        // System 을 설계 시 가장 중요한 것 중 하나가 Error Handling 임
        // Error 를 다루는 것은 User Interface 에 큰 부분을 차지한다.
        // Error 가 발생하였 을 때 User 에게 무엇이 잘 못 되었는지 어떤 것을 시도하여야 하는 지
        // 정보들을 주어야 한다.

        // Our interpreters supports two ways of running code. Lox is a scripting language, which means it executes directly from source.
        // if start jlox from command line and give it path to a file, can enter code and one line at a time
        // if you want a more interactively conversation with your interpreter, can also run directively
        if(args.length > 1) {
            System.out.println("Usage: jlox [script]");
            System.exit(64);    // For exit codes, using the conventions defined in the UNIX sysexits.h
        } else if(args.length == 1) {
            runFile(args[0]);
        } else {
            runPrompt();
        }
    }

    private static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes, Charset.defaultCharset()));
    }

    private static void runPrompt() throws IOException {
        // TODO
        // study 필요 Blocking I/O / Non Blocking I/O Studying 필요
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        for(;;) {
            System.out.println("> ");
            // read a line of input from the user on the command line and returns the result.
            // To kill interactive command-line app, when readLine() null check for that to exit the loop.
            String line = reader.readLine();
            if(line == null) {
                break;
            }
            run(line);
        }
    }

    // TODO Token Class 확인 필요 !
    private static void run(String source) {
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();
        for(Token token : tokens) {
            System.out.println(token);
        }
    }

    // TODO
    // http://www.craftinginterpreters.com/scanning.html
    // Error Handling 부분 부터 공부 필요 !!


}
