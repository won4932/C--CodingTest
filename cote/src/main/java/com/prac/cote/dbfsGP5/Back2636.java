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

    static int cheese = Integer.MAX_VALUE;

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
                int piece = Integer.parseInt(st.nextToken());
                board[i][j] = piece;
                boardClone[i][j] = piece;

            }
        }



        int count = 0;

        while(true) {

            visitied = new boolean[Y][X];

            if(bfs()) {
                count++;
                board = boardClone.clone();
            }else {
                break;
            }
        }

        System.out.println(count);
        System.out.println(cheese);
    }

    private static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visitied[0][0] = true;

        boolean ck = false;

        int chees = 0;

        while(!queue.isEmpty()) {
            int xy[] = queue.poll();

            int nowX = xy[1];
            int nowY = xy[0];

            for(int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if(nx < X && nx > -1 && ny < Y && ny > -1 && !visitied[ny][nx]) {
                    visitied[ny][nx] = true;
                    if(board[ny][nx] == 1) {
                        chees++;
                        ck = true;
                        boardClone[ny][nx] = 0;
                    }else {
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }

        cheese = chees == 0 ? cheese : Math.min(cheese, chees);

        return ck;
    }
}