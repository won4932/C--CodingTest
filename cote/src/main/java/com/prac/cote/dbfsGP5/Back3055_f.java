package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back3055_f {
    static char[][] map;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static int R, C;

    static boolean[][] visited;

    static int[] urchin;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        urchin = new int[2];

        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            String row = br.readLine();
            for(int j = 0; j < C; j++) {
                char ch = row.charAt(j);
                if(ch == 'S') {
                    urchin[0] = j;
                    urchin[1] = i;
                    map[i][j] = 'S';
                }else {
                    map[i][j] = ch;
                }

            }
        }

        min = Math.min(min, bfs(urchin[0], urchin[1]));

        System.out.println(min == -1 ? "KAKTUS" : min);
    }

    private static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        visited[y][x] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            int px = node.x;
            int py = node.y;

            System.out.println(px + " : " + py);

            if(map[py][px] == 'D') return node.count;

            rises();

            for(int a = 0; a < 4; a++) {
                int nx = px + dx[a];
                int ny = py + dy[a];

                if(nx > -1 && nx < C && ny > -1 && ny < R && !visited[ny][nx]) {
                    if(map[ny][nx] == '.' || map[ny][nx] == 'D') {
                        queue.add(new Node(nx, ny, node.count+1));
                        visited[ny][nx] = true;
                        if(map[ny][nx] == '.') map[ny][nx] = 'S';
                    }

                }
            }
        }

        return -1;

    }

    private static void rises() {
        boolean[][] waters = new boolean[R][C];

        for(int i = 0 ; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(!waters[i][j] && map[i][j] == '*') {
                    for(int a = 0; a < 4; a++) {
                        int nx = j + dx[a];
                        int ny = i + dy[a];
                        if(nx > -1 && nx < C && ny > -1 && ny < R && !waters[ny][nx] && map[ny][nx] == '.') {
                            waters[ny][nx] = true;
                            map[ny][nx] = '*';
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

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}