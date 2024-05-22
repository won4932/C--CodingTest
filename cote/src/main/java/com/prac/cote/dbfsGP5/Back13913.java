package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Back13913 {

    static int[] dp = new int[100001];

    static int N, K;

    static int min = Integer.MAX_VALUE;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N >= K) {
            min = N-K;
            for(int i = N; i >= K; i--) {
                sb.append(i).append(" ");
            }
        }else {
            bfs();
        }

        System.out.println(min);

        System.out.println(sb);

    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, String.valueOf(N)));

        dp[N] = 1;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            int now = node.location;

            if(min < dp[now]) return;

            int[] ay = new int[3];

            ay[0] = now+1;
            ay[1] = now-1;
            ay[2] = now*2;

            for (int i : ay) {

                if(i < 100001 && i > -1) {
                    if(i == K) {
                        min = dp[now];
                        if(sb.isEmpty()) {
                            sb.append(node.route).append(" ").append(i);
                        }

                    }

                    if(dp[i] == 0 || dp[i] == dp[now] + 1) {
                        queue.add(new Node(i, node.route + " " + i));
                        dp[i] = dp[now]+1;
                    }
                }
            }
        }
    }

    public static class Node {
        int location;
        String route;

        public Node(int location, String route) {
            this.location = location;
            this.route = route;
        }
    }
}