package com.prac.cote.dbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back16928 {
    static int N, M;
    static char[][] treasureMap;

    static boolean[][] visited;

    static int[] dx = {-1, 0 , 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int result = Integer.MIN_VALUE;

        treasureMap = new char[N][M];

        for(int i = 0 ; i < N ; i++) {
            String row = br.readLine();
            treasureMap[i] = row.toCharArray();
        }

        for(int i = 0 ; i < N; i++) {
            for(int j = 0 ; j < M; j++) {
                if(treasureMap[i][j] == 'L') {
                    visited = new boolean[N][M];
                    int max = bfs(i, j);
                    result = Math.max(result, max);
                }
            }
        }

        System.out.println(result);
    }

    public static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        visited[x][y] = true;

        int count = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < N && nx >= 0 && ny < M && ny >= 0 && !visited[nx][ny]  && treasureMap[nx][ny] == 'L') {
                    queue.add(new Node(nx, ny, node.count + 1));
                    count = Math.max(count, node.count + 1);
                    visited[nx][ny] = true;
                }
            }
        }

        return count;
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