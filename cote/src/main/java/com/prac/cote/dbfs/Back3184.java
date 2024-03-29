package com.prac.cote.dbfs;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back3184 {
    static char[][] ward;
    static boolean[][] visit;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static int R, C;
    static int oT = 0, vT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        ward = new char[R][C];
        visit = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            String row = br.readLine();
            for(int j = 0; j < C; j++) {
                ward[i][j] = row.charAt(j);
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(!visit[i][j]) {
//                    System.out.println(i + ", " + j);
                    bfs(i, j);
                }
            }
        }

        System.out.println(oT + " " + vT);
    }
    private static void bfs(int x, int y) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        visit[x][y] = true;

        int o = 0;
        int v = 0;

        while(!queue.isEmpty()) {
            int[] xy = queue.poll();

            if(ward[xy[0]][xy[1]] == 'o') {
                o++;
            }else if(ward[xy[0]][xy[1]] == 'v') {
                v++;
            }

            for(int i = 0; i < 4; i++) {
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];
                if(nx > -1 && nx < R -1 && ny > -1 && ny < C-1 && !visit[nx][ny] && ward[nx][ny] != '#') {
                    visit[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        if(o > v) {
            v = 0;
        }else {
            o = 0;
        }

        oT += o;
        vT += v;

    }
}