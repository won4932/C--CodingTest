package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back2146 {

    static int[][] islands;
    static int N;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static boolean[][] visitied;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        islands = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int piece = Integer.parseInt(st.nextToken());
                islands[i][j] = piece;
            }
        }


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