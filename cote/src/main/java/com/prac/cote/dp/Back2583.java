package com.prac.cote.dp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back2583 {

    static int[] dx = {-1, 0, 1, 0};

    static int[] dy = {0, -1, 0, 1};

//    static boolean[][] visited;

    static int answer;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back2583.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] graphPaper = new int[N][M];
//        visited = new boolean[N][M];

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());

            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for(int a = lx; a < rx; a++) {
                for(int b = ly; b < ry; b++) {
                    graphPaper[a][b] = 1;
                }
            }
        }

       for(int i = 0; i < N; i++) {
           for(int j = 0; j < M; j++) {
               if(graphPaper[i][j] == 0) {
                   answer = 0;
                   dfs(i, j, graphPaper, M, N);
                   result.add(answer);
               }

           }
       }
        System.out.println(result.size());
        Collections.sort(result);
        for (Integer i : result) {
            System.out.print(i + " ");

        }
    }

    public static void dfs(int x, int y, int[][] graphPaper, int M, int N) {
        answer++;
        graphPaper[x][y] = 1;

        for(int d = 0; d < 4; d++) {
            int a = x + dx[d];
            int b = y + dy[d];
            if(a > -1 && b > -1 && a < N && b < M) {
                if(graphPaper[a][b] == 0) {
                    dfs(a, b,graphPaper, M, N);
                }
            }
        }
    }
}