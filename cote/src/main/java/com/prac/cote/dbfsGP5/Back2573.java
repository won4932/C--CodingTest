package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back2573 {
    static int[][] iceberg;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        iceberg = new int[N][M];

        
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