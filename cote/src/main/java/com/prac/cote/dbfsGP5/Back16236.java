package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back16236 {
    static int[][] space;

    static boolean[][] visited;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static int N, size, eat, move;

    static int[] now;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        space = new int[N][N];

        now = new int[2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                int state = Integer.parseInt(st.nextToken());
                space[i][j] = state;

                if(state == 9) {
                    now[0] = j;
                    now[1] = i;
                    space[i][j] = 0;
                }
            }
        }

        size = 2;

        while(bfs(now[0], now[1])) {
            if(size == eat) {
                size++;
                eat = 0;
            }
        }

        System.out.println(move);

    }

    private static boolean bfs(int x, int y) {

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) ->
            o1.count != o2.count ? Integer.compare(o1.count, o2.count) : (o1.y != o2.y ? Integer.compare(o1.y, o2.y) : Integer.compare(o1.x, o2.x))
        );

        visited = new boolean[N][N];

        queue.add(new Node(x, y, 0));

        visited[y][x] = true;

        boolean ck = false;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(space[node.y][node.x] > 0 && space[node.y][node.x] < size) {
                space[node.y][node.x] = 0;
                eat++;
                move += node.count;
                ck = true;
                now[0] = node.x;
                now[1] = node.y;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx > -1 && nx < N && ny > -1 && ny < N && !visited[ny][nx] && space[ny][nx] <= size) {
                        visited[ny][nx] = true;
                        queue.add(new Node(nx, ny, node.count + 1));
                    }
                }
            }
		return ck;
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