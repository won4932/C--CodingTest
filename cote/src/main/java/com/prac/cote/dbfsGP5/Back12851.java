package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back12851 {

    static int[] dp = new int[100001];

    static int N, K;

    static int min = Integer.MAX_VALUE;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N >= K) {
            min = N-K;
            count++;
        }else {
            bfs();
        }

        System.out.println(min);
        System.out.println(count);

    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        dp[N] = 1;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(min < dp[now]) return;

            int[] ay = new int[3];

            ay[0] = now+1;
            ay[1] = now-1;
            ay[2] = now*2;

            for (int i : ay) {

                if(i < 100001 && i > -1) {
                    if(i == K) {
                        min = dp[now];
                        count++;
                    }

                    if(dp[i] == 0 || dp[i] == dp[now] + 1) {
                        queue.add(i);
                        dp[i] = dp[now]+1;
                    }
                }
            }
        }
    }
}