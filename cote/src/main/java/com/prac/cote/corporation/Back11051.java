package com.prac.cote.corporation;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back11051 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];

        System.out.println(factorial(N, K));
    }

    public static int factorial(int N, int K) {
        if(dp[N][K] > 0) {
            return dp[N][K];
        }

        if(N == K || K == 0) {
            return dp[N][K] = 1;
        }

        return dp[N][K] = (factorial(N-1, K-1) + factorial(N-1, K)) % 10007;
    }
}