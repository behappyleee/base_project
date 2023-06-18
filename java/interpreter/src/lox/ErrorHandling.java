package lox;

public class ErrorHandling {
    // error functions and its report() helper tells the users
    // some syntax errror occured on a given a time.
    static void error(int line, String message) {
        report(line, "", message);
    }

    private static void report(int line, String where, String message) {
        System.err.println("[line " + line + "] Error" + where +": " + message);
    }

}
