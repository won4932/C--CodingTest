package com.prac.cote.corporation;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back10164 {

    static int N, M, K;
    static int[][] dp;

    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        int count = 1;

        int kx = 0;
        int ky = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(i == 0 || j ==0) grid[i][j] = 1;
                else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }

                if(count == K) {
                    kx = i;
                    ky = j;
                }
                count++;
            }
        }

        System.out.println(grid[kx][ky] * grid[N - kx -1][M - ky -1]);
    }
}