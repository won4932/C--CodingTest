package com.prac.cote.dbfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back2468 {

    static int[] dx = {-1, 0, 1, 0};

    static int[] dy = {0, -1, 0, 1};

    static boolean[][] vistied;


    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back2468.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] area = new int[N][N];

        int max = 0;

        int answer;

        int result = 0;

        for(int i = 0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int h = Integer.parseInt(st.nextToken());
                max = Math.max(max, h);
                area[i][j] = h;
            }
        }

        for(int i = 0; i < max; i++) {
            answer = 0;
            vistied = new boolean[N][N];
            for(int a = 0; a < N; a++){
                for(int b = 0; b < N; b++) {
                    if(!vistied[a][b] && i < area[a][b]) {
                        answer++;
                        dfs(a, b, area, i, N);
                    }
                }
            }
            result = Math.max(result, answer);
        }

        System.out.println(result);

    }

    public static void dfs(int x, int y, int[][] area, int i, int N) {
        vistied[x][y] = true;

        for(int d = 0; d < 4; d++) {
            int a = x + dx[d];
            int b = y + dy[d];
            if(a > -1 && b > -1 && a < N && b < N) {
                if(!vistied[a][b] && area[a][b] > i) {
                    dfs(a, b, area, i, N);
                }
            }
        }
    }
}