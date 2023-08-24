package com.prac.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back12865 {

    public static void main(String[] args) throws IOException {

        SpringApplication.run(Back12865.class, args);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;

        int N = reader.read() - '0';
        int K = reader.read() - '0';

        int[] dp = new int[N];

        int[] W = new int[N];
        int[] V = new int[N];

        reader.readLine();

        for(int a = 0; a < N; a++) {
            W[a] = reader.read() - '0';
            V[a] = reader.read() - '0';
            reader.readLine();
        }

        for(int b = 0; b < N - 1; b++) {
            for(int c = 0; c < N; c++) {
                if(b == c || dp[b] != 0) continue;

                dp[b + 1] = Math.max(dp[b+1], dp[b] + dp[c]);
            }
        }



    }
}