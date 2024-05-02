package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back14502 {
    static int[][] lab;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static int N, M;

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(max);
    }

    private static void dfs(int wall) {
        if(wall == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(lab[i][j] == 0) {
                    lab[i][j] = 1;
                    dfs(wall+1);
                    lab[i][j] = 0;
                }
            }
        }
    }


    private static void bfs() {
        Queue<int []> queue = new LinkedList<>();

        int[][] copyLab = new int[N][M];

        for(int i = 0; i < N; i++){
            copyLab[i] = lab[i].clone();
            for (int j = 0; j < M; j++){
                if(lab[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] xy = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];
                if(nx > -1 && nx < N && ny > -1 && ny < M) {
                    if(copyLab[nx][ny] == 0) {
                        copyLab[nx][ny] = 2;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        maxCheck(copyLab);

    }

    private static void maxCheck(int[][] copyLab) {
        int count = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j <M; j++) {
                if(copyLab[i][j] == 0) {
                    count++;
                }
            }
        }

        max = Math.max(max, count);
    }
}