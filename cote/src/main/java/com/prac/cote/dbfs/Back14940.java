package com.prac.cote.dbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back14940 {
    static int N, M;

    static int[][] map, dp;

    static int[] impo = new int[2];

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        // Arrays.fill(dp[0], -1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int land = Integer.parseInt(st.nextToken());
                if(land == 2) {
                    impo[0] = i;
                    impo[1] = j;
                }

                if(land == 0) dp[i][j] = 0;

                map[i][j] = land;
            }
        }

        bfs(impo[0], impo[1]);

        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }

            System.out.println();
        }

    }

    public static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));

        dp[x][y] = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < N && nx >= 0 && ny < M && ny >= 0 && map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    dp[nx][ny] = node.count+1;
                    queue.add(new Node(nx, ny, node.count+1));
                }
            }

        }
    }

    static class Node {
        int x;
        int y;
        int count;

        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}