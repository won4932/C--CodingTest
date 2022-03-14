package com.prac.cote.dbfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back11724 {

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back11724.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int [][] graph;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        for(int j = 1; j <= N; j++) {
            if(!visited[j]) {
                count++;
                dfs(j, graph, N);
            }
        }

        System.out.println(count);
    }

    public static void dfs(int c, int[][] graph, int N) {
        visited[c] = true;
        for(int i = 1; i <= N; i++) {
            if(!visited[i] && graph[c][i] == 1) {
                dfs(i, graph, N);
            }
        }
    }
}