package com.prac.cote.dbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back6593 {
    static int L, R, C;

    static char[][][] building;
    static boolean[][][] dp;

    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};

    static int[] start = new int[3];
    static int[] end = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;



        while(true) {
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            building = new char[L][R][C];
            dp = new boolean[L][R][C];

            if(L == 0 && R == 0 && C == 0) break;

            for(int i = 0; i < L; i++) {
                for(int j = 0; j < R; j++) {
                    String row = br.readLine();
                    for(int k = 0; k < C; k++) {
                        char now = row.charAt(k);
                        if(now == 'S') {
                            start[0] = i;
                            start[1] = j;
                            start[2] = k;
                        }

                        if(now == 'E') {
                            end[0] = i;
                            end[1] = j;
                            end[2] = k;
                        }
                        building[i][j][k] = now;
                    }
                }
                br.readLine();
            }

            int result = bfs(start[0], start[1], start[2]);

            if(result == -1 ) {
                System.out.println("Trapped!");
            }else {
                System.out.println("Escaped in " + result + " minute(s).");
            }
        }

    }

    public static int bfs(int z, int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(z, x, y, 0));
        dp[z][x][y] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.z == end[0] && node.x == end[1] && node.y == end[2]) {
                return node.count;
            }

            for(int i = 0; i < 6; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int nz = node.z + dz[i];

                if(nx < R && nx >= 0 && ny < R && ny >= 0 && nz < L && nz >= 0
                    && !dp[nz][nx][ny] && building[nz][nx][ny] != '#') {
                    dp[nz][nx][ny] = true;
                    queue.add(new Node(nz, nx, ny, node.count+1));
                }
            }

        }

        return -1;
    }

    static class Node {
        int z;
        int x;
        int y;
        int count;

        Node(int z, int x, int y, int count) {
            this.z = z;
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}