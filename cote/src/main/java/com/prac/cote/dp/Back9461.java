package com.prac.cote.dp;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back9461 {
    static long[] dp;

    static Integer[] init;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        init = new Integer[6];

        init[1] = 1;
        init[2] = 1;
        init[3] = 1;
        init[4] = 2;
        init[5] = 2;


        for(int i = 0; i <T; i++) {
            int N = Integer.parseInt(br.readLine());
            if(N < 6) {
                System.out.println(init[N]);
                continue;
            }else {
                dp = new long[N+1];
                dp[1] = 1;
                dp[2] = 1;
                dp[3] = 1;
                dp[4] = 2;
                dp[5] = 2;
            }
            for(int j = 6; j < N+1; j++) {
                dp[j] = dp[j-1] + dp[j-5];
            }

            System.out.println(dp[N]);
        }
    }
}