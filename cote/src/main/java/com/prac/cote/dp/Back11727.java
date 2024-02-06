package com.prac.cote.dp;



import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back11727 {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N];

        dp[0] = 1;
        dp[1] = 3;

        System.out.println(dp(N-1));
    }

    public static int dp(int N) {
        if(dp[N] == null) {
            dp[N] = (dp(N-1) + (2 * dp(N-2))) % 10007;
        }

        return dp[N];

    }
}