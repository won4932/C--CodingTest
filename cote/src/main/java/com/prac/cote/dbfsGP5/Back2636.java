package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back2636 {

    static int[][] board;
    static int[][] boardClone;
    static int Y, X;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static boolean[][] visitied;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        board = new int[Y][X];
        boardClone = new int[Y][X];

        for(int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < X; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        boolean ck = true;

        int q = 3;

        while(ck) {
            ck = false;

            for(int i = 1; i < Y-1; i++) {
                for(int j = 1; j < X-1; j++) {
                    if(board[i][j] == 1) {
                        ck = true;
                        visitied = new boolean[Y][X];
                        bfs(i, j);
                    }
                }
            }

            board = boardClone.clone();
            // for (int[] ints : board) {
            //     for (int anInt : ints) {
            //         System.out.print(anInt + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
            count++;
            // q--;
        }

        System.out.println(count-1);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visitied[y][x] = true;

        while(!queue.isEmpty()) {
            int xy[] = queue.poll();

            int nowX = xy[1];
            int nowY = xy[0];

            for(int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if(nx < X && nx > -1 && ny < Y && ny > -1 && !visitied[ny][nx]) {
                    visitied[ny][nx] = true;
                    if(board[ny][nx] == 0) {
                        boardClone[nowY][nowX] = 0;
                    }else {
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}