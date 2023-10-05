package com.prac.cote.dp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1012 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1012.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] land = new int[M][N];

            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                land[x][y] = 1;
            }

            for(int a = 0; a < M; a++) {
                for(int b = 0; b < N; b++) {
                    if(land[a][b] == 1) {
                        count++;
                        dfs(a, b, land, M, N);
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int a, int b, int[][] land, int M, int N) {
        land[a][b] = 0;
            for(int d = 0; d < 4; d++) {
                int x = a + dx[d];
                int y = b + dy[d];
                if(x > -1 && y > -1 && x < M && y < N) {
                    if(land[x][y] == 1) {
                        dfs(x, y, land, M, N);
                    }
                }
            }
    }
}