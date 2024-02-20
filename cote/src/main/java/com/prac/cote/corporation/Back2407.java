package com.prac.cote.corporation;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back2407 {

    static int n, m;
    static BigInteger[][] dp;
    static int[] lotto;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new BigInteger[n + 1][m + 1];

        System.out.println(factorial(n, m));
    }

    public static BigInteger factorial(int n, int m) {
        if(dp[n][m] != null) {
            return dp[n][m];
        }

        if(n == m || m == 0) {
            return dp[n][m] = new BigInteger("1");
        }

        return dp[n][m] = factorial(n-1, m-1).add(factorial(n-1 , m));
    }
}