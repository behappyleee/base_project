import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Lox {

    public static void main(String[] args) throws IOException {
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
