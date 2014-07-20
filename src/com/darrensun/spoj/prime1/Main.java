package com.darrensun.spoj.prime1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * SPOJ 2 - Prime Generator
 * Created by Darren on 14-7-14.
 * Direct implementation of the Sieve of Eratosthenes would lead to heap overflow.
 */
public class Main {
    public final static int LIMIT = 1000000000;
    public final static int RANGE = 100000;

    public static void main(String[] args) throws IOException {
        // Generate all primes not greater than sqrt(LIMIT)
        // If n (<=LIMIT) is not prime, it must have a prime p <= sqrt(LIMIT)
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        int numOfPrimes = 1;
        for (int i = 3; i <= Math.sqrt(LIMIT); i += 2) {
            boolean isPrime = true;
            double cap = Math.sqrt(i);
            for (int j = 0; j < numOfPrimes; j++) {
                if (primes.get(j) > cap)
                    break;
                if (i % primes.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
                numOfPrimes++;
            }
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int testcases = Integer.parseInt(in.readLine());
        for (int i = 0; i < testcases; i++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int m = Integer.parseInt(tokenizer.nextToken());
            int n = Integer.parseInt(tokenizer.nextToken());
            if (m < 2)
                m = 2;

            // notPrime[i] == true if m+i is not prime
            boolean[] notPrime = new boolean[RANGE+1];

            // Mark multiples within [m,n] of all the primes as "not prime"
            for (int j = 0; j < numOfPrimes; j++) {
                int prime = primes.get(j);
                if (prime > n)
                    break;
                // Make start as the first multiple of prime larger than m
                int start = prime * 2;
                if (start < m)
                    start = m + (prime - m % prime) % prime;

                for (int k = start; k <= n; k += prime)
                    notPrime[k-m] = true;
            }

            // Print those not marked as "not prime"
            for (int j = m; j <= n; j++) {
                if (!notPrime[j-m])
                    out.println(j);
            }
            out.println();
        }
        out.flush();
    }
}
