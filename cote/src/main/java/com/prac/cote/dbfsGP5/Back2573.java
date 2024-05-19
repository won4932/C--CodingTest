package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back2573 {
    static int[][] iceberg;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static int N, M;

    static boolean[][] visitied;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        iceberg = new int[N][M];
        visitied = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;

        while(true) {
            int count = 0;

            visitied = new boolean[N][M];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(iceberg[i][j] != 0 && !visitied[i][j]) {
                        count++;
                        bfs(i, j);
                    }
                }
            }

            if(count > 1) {
                break;
            }else if(count == 0) {
                year = 0;
                break;
            }

            year++;
        }

        System.out.println(year);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visitied[y][x] = true;
        iceberg[y][x]--;



        while(!queue.isEmpty()) {
            int count = 0;
            int[] xy = queue.poll();

            int nowX = xy[1];
            int nowY = xy[0];

            for(int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if(nx < M && nx > -1 && ny < N && ny > -1 && !visitied[ny][nx]) {
                    if(iceberg[ny][nx] == 0) {
                        count++;
                    }else {
                        visitied[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    }

                }
            }

            iceberg[nowY][nowX] -= count;
            if(iceberg[nowY][nowX] < 0) iceberg[nowY][nowX] = 0;
        }



    }

    public static class Node {
        int x;
        int y;

        boolean open;

        public Node(int x, int y, boolean open) {
            this.x = x;
            this.y = y;
            this.open = open;
        }
    }
}