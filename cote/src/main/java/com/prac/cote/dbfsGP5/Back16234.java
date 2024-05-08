package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Back16234 {
    static int[][] ground;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static int N, L, R;

    static boolean[][] visited;

    static List<int[]> list;

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
            visited = new boolean[N][N];
            int sum = 0;
            boolean isMove = false;

            for(int i = 0; i < N; i ++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        sum = bfs(j, i);
                        int avg = sum / list.size();
                        if(list.size() > 1) {
                            for (int[] ints : list) {
                                ground[ints[1]][ints[0]] = avg;
                            }
                            isMove = true;
                        }
                    }
                }
            }
            if(!isMove) {
                break;
            }
            day++;
        }

        System.out.println(day);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        list = new ArrayList<>();

        queue.add(new int[]{x, y});

        visited[y][x] = true;
        list.add(new int[]{x, y});

        int sum = ground[y][x];

        while(!queue.isEmpty()) {
            int[] node = queue.poll();

            int px = node[0];
            int py = node[1];

            for(int a = 0; a < 4; a++) {
                int nx = px + dx[a];
                int ny = py + dy[a];
                if(nx > -1 && nx < N && ny > -1 && ny < N && !visited[ny][nx]) {
                    int diff = Math.abs(ground[py][px] - ground[ny][nx]);
                    if(L <= diff && diff <= R) {
                        queue.add(new int[]{nx, ny});
                        visited[ny][nx] = true;
                        list.add(new int[]{nx, ny});
                        sum+=ground[ny][nx];
                    }
                }
            }
        }

        return sum;

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