package com.prac.cote.dp;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back11053 {
    static Integer[] dp;
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int A = Integer.parseInt(br.readLine());

        dp = new Integer[A];
        sequence = new int[A];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i <A; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

//        Arrays.sort(sequence);

        for(int i = 0; i < A; i++) {
            dp(i);
        }

        int max = dp[0];
        // 최댓값 찾기
        for(int i = 1; i < A; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    public static int dp(int N) {
        if(dp[N] == null) {
            dp[N] = 1;	// 1로 초기화

            // N-1 부터 0까지중 N보다 작은 값들을 찾으면서 재귀호출.
            for(int i = N - 1; i >= 0; i--) {
                if(sequence[i] < sequence[N]) {
                    dp[N] = Math.max(dp[N], dp(i) + 1);
                }
            }
        }
        return dp[N];
    }
}