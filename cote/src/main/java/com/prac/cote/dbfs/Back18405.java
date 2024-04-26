package com.prac.cote.dbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back18405 {
    static int N, M, R;

    static List<List<Integer>> graph;

    static int[] visited;

    static StringBuffer sb = new StringBuffer();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        graph = new ArrayList<>();

        for(int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        bfs(R);

        for(int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        int count = 1;
        visited[idx] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Integer i : graph.get(now)) {
                if(visited[i] == 0) {
                    count++;
                    visited[i] = count;
                    queue.add(i);
                }
            }
        }
    }

}