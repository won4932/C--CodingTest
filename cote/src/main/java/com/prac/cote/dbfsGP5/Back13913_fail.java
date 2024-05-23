package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back13913_fail {

    static int[] dp = new int[100001];
    static int[] order;

    static int N, K;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N >= K) {
            min = N-K;
        }else {
            bfs();
        }

        order = new int[min+1];
        order[0] = N;
        dfs(N, 1);

        StringBuilder sb = new StringBuilder();

        System.out.println(min);
        for (int i : order) {
			sb.append(i).append(" ");
        }

        System.out.println(sb.toString());

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
                    }

                    if(dp[i] == 0 || dp[i] == dp[now] + 1) {
                        queue.add(i);
                        dp[i] = dp[now]+1;
                    }
                }
            }
        }
    }

    private static boolean dfs(int n, int count) {
        if(n == K) {
            return true;
        }

        if(count > min) return false;

        int[] ay = new int[3];

        ay[0] = n+1;
        ay[1] = n-1;
        ay[2] = n*2;

        for (int i : ay) {
            if(i < 100001 && i > -1) {
                if(dfs(i, count+1)) {
                    order[count] = i;
                    return true;
                }
            }
        }
        return false;
    }
}