package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back2206 {
    static int[][] lab;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static int N, M;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];

        for(int i = 0; i < N; i++) {
            String row = br.readLine();
            for(int j = 0; j < M; j++) {
                lab[i][j] = row.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(lab[i][j] == 1) {
                    lab[i][j] = 0;
                    bfs();
                    lab[i][j] = 1;
                }
            }
        }

        System.out.println(min);
    }

    private static void bfs() {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        int count = 0;


        while(!queue.isEmpty()) {
            int[] xy = queue.poll();

            if(xy[0] == N-1 && xy[1] == M-1) {
                min = Math.min(min, count);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = xy[1] + dx[i];
                int ny = xy[0] + dy[i];
                if(nx > -1 && nx < M && ny > -1 && ny < N) {
                    if(lab[ny][nx] == 0 && !visited[ny][nx]) {
                        count++;
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}