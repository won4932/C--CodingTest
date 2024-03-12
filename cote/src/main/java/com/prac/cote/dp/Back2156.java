package com.prac.cote.dp;



import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back2156 {

    static Integer[] dp;

    static Integer[] grapes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        grapes = new Integer[N + 1];

        for(int i = 1; i <= N; i++) {
            grapes[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = grapes[1];

        if(N > 1) {
            dp[2] = grapes[1] + grapes[2];
        }

        System.out.println(dp(N));
    }

    public static int dp(int N) {
        if(dp[N] == null) {
            dp[N] = Math.max(Math.max(dp(N-2), dp(N-3) + grapes[N-1]) + grapes[N], dp(N-1));
        }

        return dp[N];

    }
}