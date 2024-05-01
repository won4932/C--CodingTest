package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back2206_timeout {
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

        min = min == Integer.MAX_VALUE ? -1 : min;

        System.out.println(min);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;


        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.x == N-1 && node.y == M-1) {
                min = Math.min(min, node.count);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = node.y + dx[i];
                int ny = node.x + dy[i];
                if(nx > -1 && nx < M && ny > -1 && ny < N) {
                    if(lab[ny][nx] == 0 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new Node(ny, nx, node.count+1));
                    }
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}