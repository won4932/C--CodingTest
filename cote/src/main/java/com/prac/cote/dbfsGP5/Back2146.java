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

    static boolean[][] visited;

    static int min = Integer.MAX_VALUE;

    // static Queue<Node> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        islands = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int piece = Integer.parseInt(st.nextToken());
                islands[i][j] = piece;
            }
        }

        int color = 1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(islands[i][j] == 1 && !visited[i][j]) {
                    land(i, j, color);
                    color++;
                }

            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(islands[i][j] != 0) {
                    visited = new boolean[N][N];
                    search(i, j, islands[i][j]);
                }

            }
        }

        System.out.println(min-1);
    }

    private static void land(int y, int x, int color) {
        Queue<int[]> landQueue = new LinkedList<>();
        landQueue.add(new int[]{y, x});
        visited[y][x] = true;
        islands[y][x] = color;

        while(!landQueue.isEmpty()) {
            int[] xy = landQueue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = xy[1] + dx[i];
                int ny = xy[0] + dy[i];

                if(nx < N && nx > -1 && ny < N && ny > -1 && !visited[ny][nx] && islands[ny][nx] > 0) {
                    visited[ny][nx] = true;
                    islands[ny][nx] = color;
                    landQueue.add(new int[]{ny, nx});
                }
            }
        }
    }

    private static void search(int y, int x, int color) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, color, 0));

        visited[y][x] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.count+1 > min) break;

            int nowX = node.x;
            int nowY = node.y;

            for(int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if(nx < N && nx > -1 && ny < N && ny > - 1 && !visited[ny][nx]) {
                    if(islands[ny][nx] == 0) {
                        queue.add(new Node(nx, ny, node.color, node.count+1));
                        visited[ny][nx] = true;
                    }
                    else if(islands[ny][nx] != node.color) {
                        min = Math.min(min, node.count+1);
                    }else {
                        visited[ny][nx] = true;
                    }

                }
            }
        }
    }

    private static void bfs() {

    }

    public static class Node {
        int x;
        int y;
        int color;

        int count;

        public Node(int x, int y, int color, int count) {
            this.x = x;
            this.y = y;
            this.color = color;
            this.count = count;
        }
    }
}