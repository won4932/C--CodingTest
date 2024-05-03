package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back13460 {
    static char[][] board;

    static int N, M, min = Integer.MAX_VALUE;

    static int[] red, blue, hole;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        red = new int[2];
        blue = new int[2];
        hole = new int[2];

        board = new char[N][M];

        for(int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j <M; j++) {
                char ch = row.charAt(j);
                board[i][j] = ch;

                if(ch == 'R') {
                    red[0] = j;
                    red[1] = i;
                    board[i][j] = '.';
                }else if(ch == 'B') {
                    blue[0] = j;
                    blue[1] = i;
                    board[i][j] = '.';
                }else if(ch == 'O') {
                    hole[0] = j;
                    hole[1] = i;
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Marble> queue = new LinkedList<>();
        queue.add(new Marble(red[0], red[1], blue[0], blue[1], 0));

        while(!queue.isEmpty()) {
            Marble marble = queue.poll();

            if(marble.count == 10) {
                break;
            }

            for(int i =0 ; i < 4; i++) {
                MarbleCk red = tilting(dx[i], dy[i], marble.rx, marble.ry);
                MarbleCk blue = tilting(dx[i], dy[i], marble.bx, marble.by);

                int rnx = red.x;
                int rny = red.y;
                int bnx = blue.x;
                int bny = blue.y;

                if(blue.ck) continue;

                if(red.ck) {
                    return marble.count+1;
                }

                if (marble.rx == rnx && marble.ry == rny && marble.bx == bnx && marble.by == bny) {
                    continue;
                }

                if(red.x == blue.x && red.y == blue.y) {
                    if(i == 0) {
                        if(marble.ry < marble.by) rny--;
                        else bny--;
                    }else if(i == 1) {
                        if(marble.ry < marble.by) bny++;
                        else rny++;
                    }else if(i == 2) {
                        if(marble.rx < marble.bx) bnx++;
                        else rnx++;
                    }else if(i == 3) {
                        if(marble.rx < marble.bx) rnx--;
                        else bnx--;
                    }
                }
                queue.add(new Marble(rnx, rny, bnx, bny, marble.count+1));
            }
        }

        return -1;
	}

    private static MarbleCk tilting(int xWay, int yWay, int rx, int ry) {
        boolean ck = false;
        while(board[ry + yWay][rx + xWay] != '#') {
            rx += xWay;
            ry += yWay;

            if(rx == hole[0] && ry == hole[1]) {
                ck = true;
                break;
            }
        }

        return new MarbleCk(rx, ry, ck);
    }

    public static class Marble {
        int rx;
        int ry;
        int bx;
        int by;
        int count;

        public Marble(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }

    public static class MarbleCk {
        int x;
        int y;
        boolean ck;

        public MarbleCk(int x, int y, boolean ck) {
            this.x = x;
            this.y = y;
            this.ck = ck;
        }
    }


}