package com.prac.cote.dbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back11060 {
    static int N;

    static int[] miro, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        miro = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            miro[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1];
        Arrays.fill(dp, 1001);
        dp[1] = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = i+1; j < i+1+miro[i]; j++) {
                if(j > N) break;
                dp[j] = Math.min(dp[j], dp[i]+1);
            }
        }

        for (int i : dp) {
            System.out.println(i);
        }

        System.out.println(dp[N] == 1001 ? -1 : dp[N]);

    }

}