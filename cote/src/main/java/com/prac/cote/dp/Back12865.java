package com.prac.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back12865 {

    static Integer[][] dp;

    public static void main(String[] args) throws IOException {

        SpringApplication.run(Back12865.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N + 1]; // 무게
        int[] V = new int[N + 1]; // 가치
        dp = new Integer[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dp(N-1, K, W, V));

    }

    public static int dp(int obj, int weight, int[] W, int[] V) {
        if(obj < 0) {
            return 0;
        }

        if(dp[obj][weight] == null) {
            if(W[obj] > weight) dp[obj][weight] = dp(obj-1, weight, W, V);
            else {
                dp[obj][weight] = Math.max(dp(obj-1, weight, W, V), dp(obj-1, weight - W[obj], W, V) + V[obj]);
            }

        }

        return dp[obj][weight];
    }
}