package com.book.cleancode.chapter_9;

import java.io.PrintStream;
import java.util.ArrayList;

public class PrintPrimes_Clean {

    // 가장 먼저 눈에 띄는 변화는 프로그램이 길어졌다는 것이다.
    // 길이가 늘어난 이유는 여러가지가 있다.
    // 첫쨰. 리팩토링한 프로그램은 조금더 길고 서술적인 변수이름을 사용하였다.
    // 둘쨰. 리팩토링한 프로그램은 코드에 주석을 추가하는 수단으로 함수 선언과 클래스 선언을 사용
    // 셋째. 가독성을 높이고자 공백을 추가하고 형식을 맞춤

    // 프로그램은 책임은 세 가지 책임으로 나뉘어졌다.
    // PrimePrinter 클래스는 main 함수 하나만 포함하여 실행 환경을 책임짐
    // 호출 방식이 변경 되면 클래스도 바뀐다, 예를 들어 프로그램을 SOAP 서비스로 바꾸려면 PrimePrinter 클래스를 고쳐 준다.

    // RowColumnPagePrinter 클래스는 숫자 목록을 주어진 행과 열에 맞춰 페이지에 출력하는 방법을 안다.
    // 출력하는 모양새를 바꾸려면 RowColumnPagePrinter 클래스를 고쳐준다.

    // 대다수 시스템은 지속적인 변경이 가해진다. 꺠끗한 시스템은 클래스를 체계적으로 정리해 변경에 수반하는 위험을 낮춘다.

    // Refactoring Version
    public class PrimePrinter {
        public void main(String[] args) {
            final int NUMBER_OF_PRIMES = 1000;
            int[] primes = PrimeGenerator.generate(NUMBER_OF_PRIMES);

            final int ROWS_PER_PAGE = 50;
            final int COLUMS_PER_PAGE = 4;

            RowColumnPagePrinter tablePrinter =
                    new RowColumnPagePrinter(ROWS_PER_PAGE, COLUMS_PER_PAGE,
                            "The First " + NUMBER_OF_PRIMES
                            + " Prime Numbers");

            tablePrinter.print(primes);
        }
    }

    public class RowColumnPagePrinter {
        private int rowsPerPage;
        private int columnsPerPage;
        private int numbersPerPage;
        private String pageHeader;
        private PrintStream printStream;

        public RowColumnPagePrinter(int rowsPerPage, int columnsPerPage, String pageHeader) {
            this.rowsPerPage = rowsPerPage;
            this.columnsPerPage = columnsPerPage;
            this.pageHeader = pageHeader;
            numbersPerPage = rowsPerPage * columnsPerPage;
            printStream = System.out;
        }

        public void print(int data[]) {
            int pageNumber = 1;
            for (int firstIndexOnPage = 0 ;
                 firstIndexOnPage < data.length ;
                 firstIndexOnPage += numbersPerPage) {
                int lastIndexOnPage =  Math.min(firstIndexOnPage + numbersPerPage - 1, data.length - 1);
                printPageHeader(pageHeader, pageNumber);
                printPage(firstIndexOnPage, lastIndexOnPage, data);
                printStream.println("\f");
                pageNumber++;
            }
        }

        private void printPage(int firstIndexOnPage, int lastIndexOnPage, int[] data) {
            int firstIndexOfLastRowOnPage =
                    firstIndexOnPage + rowsPerPage - 1;
            for (int firstIndexInRow = firstIndexOnPage ;
                 firstIndexInRow <= firstIndexOfLastRowOnPage ;
                 firstIndexInRow++) {
                printRow(firstIndexInRow, lastIndexOnPage, data);
                printStream.println("");
            }
        }

        private void printRow(int firstIndexInRow, int lastIndexOnPage, int[] data) {
            for (int column = 0; column < columnsPerPage; column++) {
                int index = firstIndexInRow + column * rowsPerPage;
                if (index <= lastIndexOnPage)
                    printStream.format("%10d", data[index]);
            }
        }

        private void printPageHeader(String pageHeader, int pageNumber) {
            printStream.println(pageHeader + " --- Page " + pageNumber);
            printStream.println("");
        }

        public void setOutput(PrintStream printStream) {
            this.printStream = printStream;
        }
    }

    public class PrimeGenerator {
        private static int[] primes;
        private static ArrayList<Integer> multiplesOfPrimeFactors;

        protected static int[] generate(int n) {
            primes = new int[n];
            multiplesOfPrimeFactors = new ArrayList<Integer>();
            set2AsFirstPrime();
            checkOddNumbersForSubsequentPrimes();
            return primes;
        }

        private static void set2AsFirstPrime() {
            primes[0] = 2;
            multiplesOfPrimeFactors.add(2);
        }

        private static void checkOddNumbersForSubsequentPrimes() {
            int primeIndex = 1;
            for (int candidate = 3 ; primeIndex < primes.length ; candidate += 2) {
                if (isPrime(candidate))
                    primes[primeIndex++] = candidate;
            }
        }

        private static boolean isPrime(int candidate) {
            if (isLeastRelevantMultipleOfNextLargerPrimeFactor(candidate)) {
                multiplesOfPrimeFactors.add(candidate);
                return false;
            }
            return isNotMultipleOfAnyPreviousPrimeFactor(candidate);
        }

        private static boolean isLeastRelevantMultipleOfNextLargerPrimeFactor(int candidate) {
            int nextLargerPrimeFactor = primes[multiplesOfPrimeFactors.size()];
            int leastRelevantMultiple = nextLargerPrimeFactor * nextLargerPrimeFactor;
            return candidate == leastRelevantMultiple;
        }

        private static boolean isNotMultipleOfAnyPreviousPrimeFactor(int candidate) {
            for (int n = 1; n < multiplesOfPrimeFactors.size(); n++) {
                if (isMultipleOfNthPrimeFactor(candidate, n))
                    return false;
            }
            return true;
        }

        private static boolean isMultipleOfNthPrimeFactor(int candidate, int n) {
            return candidate == smallestOddNthMultipleNotLessThanCandidate(candidate, n);
        }

        private static int smallestOddNthMultipleNotLessThanCandidate(int candidate, int n) {
            int multiple = multiplesOfPrimeFactors.get(n);
            while (multiple < candidate)
                multiple += 2 * primes[n];
            multiplesOfPrimeFactors.set(n, multiple);
            return multiple;
        }
    }


    // PrintPrimes 프로그램을 자바로 변환한 코드이다.
    // 해당 함수는 함수가 1개뿐이 엉망 진창인 코드이다.
    // 들여쓰기가 심하고, 이상한 변수가 많고 구조가 빡빡하게 결합되어있다.
//    public static void main(String[] args) {
//        final int M = 1000;
//        final int RR = 50;
//        final int CC = 4;
//        final int WW = 10;
//        final int ORDMAX = 30;
//        int P[] = new int[M + 1];
//        int PAGENUMBER;
//        int PAGEOFFSET;
//        int ROWOFFSET;
//        int C;
//        int J;
//        int K;
//        boolean JPRIME;
//        int ORD;
//        int SQUARE;
//        int N;
//        int MULT[] = new int[ORDMAX + 1];
//
//        J = 1;
//        K = 1;
//        P[1] = 2;
//        ORD = 2;
//        SQUARE = 9;
//
//        while (K < M) {
//            do {
//                J = J + 2;
//                if (J == SQUARE) {
//                    ORD = ORD + 1;
//                    SQUARE = P[ORD] * P[ORD];
//                    MULT[ORD - 1] = J;
//                }
//                N = 2;
//                JPRIME = true;
//                while (N < ORD && JPRIME) {
//                    while (MULT[N] < J)
//                        MULT[N] = MULT[N] + P[N] + P[N];
//                    if (MULT[N] == J)
//                        JPRIME = false;
//                    N = N + 1;
//                }
//            } while (!JPRIME);
//            K = K + 1;
//            P[K] = J;
//        }
//        {
//            PAGENUMBER = 1;
//            PAGEOFFSET = 1;
//            while (PAGEOFFSET <= M) {
//                System.out.println("The First " + M +
//                        " Prime Numbers --- Page " + PAGENUMBER);
//                System.out.println("");
//                for (ROWOFFSET = PAGEOFFSET; ROWOFFSET < PAGEOFFSET + RR; ROWOFFSET++){
//                    for (C = 0; C < CC;C++)
//                        if (ROWOFFSET + C * RR <= M)
//                            System.out.format("%10d", P[ROWOFFSET + C * RR]);
//                    System.out.println("");
//                }
//                System.out.println("\f");
//                PAGENUMBER = PAGENUMBER + 1;
//                PAGEOFFSET = PAGEOFFSET + RR * CC;
//            }
//        }
//    }
}
