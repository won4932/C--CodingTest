package com.prac.cote.dp;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1010 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());



        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            dp = new int[M + 1][N + 1];

            System.out.println(factorial(M, N));
        }

    }

    public static int factorial(int N, int K) {
        if(dp[N][K] > 0) {
            return dp[N][K];
        }

        if(N == K || K == 0) {
            return dp[N][K] = 1;
        }

        return dp[N][K] = factorial(N-1, K-1) + factorial(N-1, K);
    }
}