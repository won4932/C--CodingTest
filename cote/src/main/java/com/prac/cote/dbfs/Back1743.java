package com.prac.cote.dbfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1743 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1743.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] path = new int[N+1][M+1];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            path[r][c] = 1;
        }

        int max = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <=M; j++) {
                max = Math.max(max, answer);
                answer = 1;
                if(path[i][j] == 1)
                dfs(i, j, path, N, M);

            }
        }
        System.out.println(max);
    }

    public static void dfs(int r, int c, int[][] path, int N, int M) {
        System.out.println(r + " : " + c);
        path[r][c] = 0;


        for(int d = 0; d < 4; d++) {
            int x = r + dx[d];
            int y = c + dy[d];
            if(x > -1 && y > -1 && x <= N && y <= M) {
                if(path[x][y] == 1) {
                    answer++;
                    dfs(x, y, path, N, M);
                }
            }
        }
    }
}