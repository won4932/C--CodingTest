package com.prac.cote.dp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back10026 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static boolean[][] visitedBlindness;

    static int answer;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back10026.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        char [][] area;
        char [][] areaBlindness;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        area = new char[N][N];
        areaBlindness = new char[N][N];
        visited = new boolean[N][N];
        visitedBlindness = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String color = st.nextToken();
            for(int j = 0; j < N; j++) {
                char c = color.charAt(j);
                area[i][j] = c;
                if(c == 'R' || c == 'G') {
                    areaBlindness[i][j] = 'R';
                }else {
                    areaBlindness[i][j] = c;
                }
            }
        }

        int count = 0;
        int count2 = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    count++;
                    dfs(i, j, area, N, area[i][j], visited);
                }

                if(!visitedBlindness[i][j]) {
                    count2++;
                    dfs(i, j, areaBlindness, N, areaBlindness[i][j], visitedBlindness);
                }

            }
        }

        System.out.println(count + " " + count2);

    }

    public static void dfs(int x, int y, char[][] area, int N, char c, boolean[][] v) {
        v[x][y] = true;
        for(int d = 0; d < 4; d++) {
            int a = x + dx[d];
            int b = y + dy[d];
            if(a > -1 && b > -1 && a < N && b < N) {
                if(!v[a][b] && area[a][b] == c) {
                    dfs(a, b, area, N, c, v);
                }
            }
        }
    }
}