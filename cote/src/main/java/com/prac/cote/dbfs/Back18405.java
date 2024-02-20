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
    static int N, K, S, X, Y;

    static int[][] examiner;

    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static StringBuffer sb = new StringBuffer();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        examiner = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                examiner[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        for(int a = 0; a < S; a++) {
            for(int b = 1; b <= K; b++) {
                visited = new boolean[N][N];
                for(int i = 0; i < N; i++) {
                    for(int j = 0; j < N; j++) {
                        if(!visited[i][j] && examiner[i][j] == b) {
                            if(bfs(i, j, b)) {
                                return;
                            }
                        }

                    }
                }

                if(examiner[X-1][Y-1] != 0) {
                    System.out.println(examiner[X-1][Y-1]);
                    return;
                }
            }
        }



        System.out.println(examiner[X-1][Y-1]);


    }

    public static boolean bfs(int x, int y, int separator) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < N && nx >= 0 && ny < N && ny >= 0 && !visited[nx][ny] && examiner[nx][ny] == 0) {
                visited[nx][ny] = true;
                examiner[nx][ny] = separator;
            }
        }

        return false;
    }

}