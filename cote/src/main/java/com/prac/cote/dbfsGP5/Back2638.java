package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back2638 {

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
                int piece = Integer.parseInt(st.nextToken());
                board[i][j] = piece;
                boardClone[i][j] = piece;

            }
        }



        int count = 0;

        while(true) {

            externalAirCk();

            boolean ck = false;

            visitied = new boolean[Y][X];

            for(int i = 0; i < Y; i++) {
                for(int j = 0; j < X; j++) {
                    if(board[i][j] == 1 && !visitied[i][j]) {
                        ck = true;
                        bfs(i, j);
                    }
                }
            }

            if(ck) {
                count++;
                board = boardClone.clone();
            }else {
                break;
            }
        }

        System.out.println(count);
    }

    private static void externalAirCk() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        board[0][0] = 2;

        boolean[][] exVisited = new boolean[Y][X];

        exVisited[0][0] = true;

        while(!queue.isEmpty()) {
            int xy[] = queue.poll();

            int nowX = xy[1];
            int nowY = xy[0];

            for(int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if(nx < X && nx > -1 && ny < Y && ny > -1 && !exVisited[ny][nx]) {
                    exVisited[ny][nx] = true;
                    if(board[ny][nx] == 0) {
                        queue.add(new int[]{ny, nx});
                        board[ny][nx] = 2;
                    }else if(board[ny][nx] == 2){
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }


    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visitied[y][x] = true;

        while(!queue.isEmpty()) {
            int xy[] = queue.poll();

            int air = 0;

            int nowX = xy[1];
            int nowY = xy[0];

            for(int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if(nx < X && nx > -1 && ny < Y && ny > -1 && !visitied[ny][nx]) {
                    if(board[ny][nx] == 2) {
                        air++;
                    }else {
                        visitied[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }

            if(air > 1) {
                boardClone[nowY][nowX] = 0;
            }
        }
    }
}