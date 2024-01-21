package com.prac.cote.dp;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1932 {
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i <n; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        int max = dp[0];

        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i], dp[i-1] + dp[i]);

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}