package strategy.compression;

import java.util.LinkedList;
import java.util.Queue;

public class Compressor {
    private CompressionStrategy strategy;

    public void setCompressionStrategy(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public String compress(String data) {
        return strategy.compress(data);
    }

    // 5 * factorial(4)
    // 5 * 4 * factorial(3)
    // 5 * 4 * 3 * factorial(2)

    private static int factorial(int number) {
        if (number > 1) {
            return number * factorial(number - 1);
        } else {
            return number;
        }
    }

    private static int whileNum(int number) {
        int multiNum = 1;
        while (number > 1) {
            multiNum *= number;
            number--;
        }

        return multiNum;
    }

    public static int recursiveTest(int testNum) {
        if (testNum == 5) {
            return testNum;
        }
        System.out.println("START");
        recursiveTest(testNum ++);
        System.out.println("END");
        return testNum;
    }

    public static void test() {
        Queue<Integer> queueTest = new LinkedList<>();
        queueTest.add(1);
        queueTest.add(2);
        queueTest.add(3);

        while (!queueTest.isEmpty()) {
            int a = queueTest.poll();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int fiveFactorial = factorial(5);
        System.out.println(fiveFactorial);

        int whileNum = whileNum(5);
        System.out.println(whileNum);
    }
}
