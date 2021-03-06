package com.prituladima.geeksforgeeks.math.modular;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;


/**
 * @see "https://www.geeksforgeeks.org/multiplicative-inverse-under-modulo-m/"
 */
public class ModularMultiplicativeInverse {

    private void solve() {


        int t = nextInt();
        while (t-- > 0) {

            int a = nextInt(), m = nextInt();
            int[] coef = {1, 1};

            int gcd = gcdExtended(a, m, coef);
            if (gcd == 1) {
                souf("%d\n", save_mod(coef[0], m));
            } else {
                souf("%d\n", -1);
            }
        }

    }

    long save_mod(long x, long m) {
        return (x % m + m) % m;
    }


    public int gcdExtended(int a, int b, int[] coef) {
        // Base Case
        if (a == 0) {
            coef[0] = 0;
            coef[1] = 1;
            return b;
        }

        int[] t = {1, 1}; // To store results of recursive call
        int gcd = gcdExtended(b % a, a, t);

        // Update t using results of recursive
        // call

        coef[0] = t[1] - (b / a) * t[0];
        coef[1] = t[0];


        return gcd;
    }

    public static void main(String[] args) {
        new ModularMultiplicativeInverse().run();
    }

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    private void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            writer = new PrintWriter(System.out);
            solve();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private int nextInt() {
        return parseInt(nextToken());
    }

    private long nextLong() {
        return parseLong(nextToken());
    }

    private double nextDouble() {
        return parseDouble(nextToken());
    }

    private int[] nextArr(int size) {
        return stream(new int[size]).map(c -> nextInt()).toArray();
    }

    private long[] nextArrL(int size) {
        return stream(new long[size]).map(c -> nextLong()).toArray();
    }

    private double[] nextArrD(int size) {
        return stream(new double[size]).map(c -> nextDouble()).toArray();
    }

    private char[][] nextCharMatrix(int n) {
        return range(0, n).mapToObj(i -> nextToken().toCharArray()).toArray(char[][]::new);
    }

    private int[][] nextIntMatrix(final int n, final int m) {
        return range(0, n).mapToObj(i -> nextArr(m)).toArray(int[][]::new);
    }

    private double[][] nextDoubleMatrix(int n, int m) {
        return range(0, n).mapToObj(i -> nextArr(m)).toArray(double[][]::new);
    }

    private String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    private void souf(String format, Object... args) {
        writer.printf(format, args);
    }

    private void sout(Object o) {
        writer.print(o);
    }

    private void newLine() {
        writer.println();
    }

    private void soutnl(Object o) {
        sout(o);
        newLine();
    }

    private int max(int a, int b) {
        return Math.max(a, b);
    }

    private int min(int a, int b) {
        return Math.min(a, b);
    }


}
