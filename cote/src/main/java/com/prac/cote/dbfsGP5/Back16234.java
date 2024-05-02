package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back16234 {
    static int[][] ground;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static int N, L, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        ground = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;

        while(true) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            boolean[][] union = new boolean[N][N];

            day++;

            int count = 1;

            var set = new HashSet<Integer>();

            while(!queue.isEmpty()) {
                int[] node = queue.poll();

                int x = node[0];
                int y = node[1];

                if(x == N-1 && y == N-1) break;

                for(int a = 0; a < 4; a++) {
                    int nx = x + dx[a];
                    int ny = y + dy[a];
                    if(nx > -1 && nx < N && ny > -1 && ny < N) {
                        queue.add(new int[]{nx, ny});
                        int diff = Math.abs(ground[y][x] - ground[ny][nx]);
                        if(L <= diff && diff <= R) {
                            union[y][x] = true;
                            set.add(ground[y][x]);
                            set.add(ground[ny][nx]);
                            count++;
                        }
                    }
                }
            }

            int sum = set.stream().mapToInt(l -> l).sum();

            for(int a = 0; a < N; a++) {
                for(int b = 0; b < N; b++) {
                    if(union[b][a]) {
                        ground[b][a] = sum / count;
                    }
                }
            }

            if(count >= N * N) break;
            else if(count == 1) {
                day--;
                break;
            }

        }

        System.out.println(day);


    }

    private static void bfs(int x, int y) {

    }

    public static class Node {
        int x;
        int y;

        boolean open;

        public Node(int x, int y, boolean open) {
            this.x = x;
            this.y = y;
            this.open = open;
        }
    }
}