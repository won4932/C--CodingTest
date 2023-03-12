package com.prac.cote.dp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back2583 {

    static boolean[] visited;

    static int[] result;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back2583.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] graphPaper = new int[N+1][M+1];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());

            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for(int a = lx; a <= rx; a++) {
                for(int b = ly; b <= ry; b++) {
                    graphPaper[a][b] = 1;
                }
            }
        }

       for(int i = 0; i <= N; i++) {
           for(int j = 0; j <= M; j++) {
               dfs(i, j, graphPaper)
           }
       }

    }

    public static void dfs(int i, List<List<Integer>> list) {
        visited[i] = true;

        for (Integer integer : list.get(i)) {
            if(!visited[integer]) {
                result[integer] = i;
                bfs(integer, list);
            }

        }
    }
}