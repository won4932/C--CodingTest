package com.prac.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back12865 {

    public static void main(String[] args) throws IOException {

        SpringApplication.run(Back12865.class, args);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = 0;

        int[][] dp = new int[N][N];

        int[] W = new int[N];
        int[] V = new int[N];

        for(int a = 0; a < N; a++) {
            st = new StringTokenizer(reader.readLine());
            W[a] = Integer.parseInt(st.nextToken());
            V[a] = Integer.parseInt(st.nextToken());
        }

        for(int b = 0; b < N -1 ; b++) {
            dp[b][0] = W[b];
            dp[b][1] = V[b];

            for(int c = b + 1; c < N; c++) {
                if(W[b]+W[c] > K) continue;

                dfs(c + 1, V[b] + V[c], N);


            //     if(dp[b][0] + W[c] > K) continue;
            //     for(int d = c + 1; d < N; d++) {
            //
            //     }
            //     dp[b][0] += W[c];
            //     dp[b][1] = Math.max(dp[b][1], dp[b][1] + V[c]);
            }
            // result = Math.max(result, dp[b][1]);
        }

        System.out.println(result);

    }

    public void dfs(int start, int sum, int size) {
        for(int a = start; a < size; a++) {

        }
    }
}