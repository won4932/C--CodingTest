package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back16234 {
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

        bfs();

        min = min == Integer.MAX_VALUE ? -1 : min;

        System.out.println(min);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, false));
        boolean[][][] visited = new boolean[N][M][2];


        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.x == N-1 && node.y == M-1) {
                min = Math.min(min, node.count);
                return;
            }

            int nCount = node.count+1;

            for(int i = 0; i < 4; i++) {
                int nx = node.y + dx[i];
                int ny = node.x + dy[i];
                if(nx > -1 && nx < M && ny > -1 && ny < N) {
                    if(lab[ny][nx] == 0) {
                        if(!node.wall && !visited[ny][nx][0]) {
                            queue.add(new Node(ny, nx, nCount, false));
                            visited[ny][nx][0] = true;
                        }else if(node.wall && !visited[ny][nx][1]) {
                            queue.add(new Node(ny, nx, nCount, true));
                            visited[ny][nx][1] = true;
                        }
                    }else if(lab[ny][nx] == 1) {
                        if(!node.wall) {
                            queue.add(new Node(ny, nx, nCount, true));
                            visited[ny][nx][1] = true;
                        }
                    }
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;
        int count;

        boolean wall;

        public Node(int x, int y, int count, boolean wall) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.wall = wall;
        }
    }
}