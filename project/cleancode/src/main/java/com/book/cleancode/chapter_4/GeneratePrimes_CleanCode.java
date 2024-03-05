package com.book.cleancode.chapter_4;

/**
 * This class Generates prime numbers up to a user specified
 * maximum. The algorithm used is the Sieve of Eratosthenes.
 *
 * @author Alphonse
 * @version 13 Feb 2002 atp
 */

public class GeneratePrimes_CleanCode {

    // 필요없는 주석까지 추가한 코드 필요 없는 주석은 너무 혼잡 스럽다.

    /**
     * @param maxValue is the generation limit.
     */

    private static boolean crossedOut;
    private static int[] result;

    public static int[] generatePrimesTest(int maxValue) {
        if (maxValue < 2) {
            return new int[0];
        } else {
            uncrossIntegersUpTo(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();
            return result;
        }

        // FOR TEST !
//        return new int[0];
    }


    public static int[] generatePrimes(int maxValue)
    {
        if (maxValue >= 2) // the only valid case
        {
            // declarations
            int s = maxValue + 1; // size of array
            boolean[] f = new boolean[s];
            int i;
            // initialize array to true.
            for (i = 0; i < s; i++)
                f[i] = true;

            // get rid of known non-primes
            f[0] = f[1] = false;

            // sieve
            int j;
            for (i = 2; i < Math.sqrt(s) + 1; i++)
            {
                if (f[i]) // if i is uncrossed, cross its multiples.
                {
                    for (j = 2 * i; j < s; j += i)
                        f[j] = false; // multiple is not prime
                }
            }

            // how many primes are there?
            int count = 0;
            for (i = 0; i < s; i++)
            {
                if (f[i])
                    count++; // bump count.
            }

            int[] primes = new int[count];

            // move the primes into the result
            for (i = 0, j = 0; i < s; i++)
            {
                if (f[i])             // if prime
                    primes[j++] = i;
            }

            return primes; // return the primes
        }
        else // maxValue < 2
            return new int[0]; // return null array if bad input.
    }

    public static void main(String[] args) {
        for (int i: generatePrimes(50)) {
            System.out.print(i + " ");
        }
    }
}
