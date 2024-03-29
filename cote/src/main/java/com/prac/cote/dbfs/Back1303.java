package com.prac.cote.dbfs;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back1303 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visit;
    static int N, M, B, W;
    static char[][] battleground;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        visit = new boolean[N][M];
        battleground = new char[N][M];

        for(int i = 0; i < N; i++) {
            String row = br.readLine();
            for(int j = 0; j < M; j++) {
                battleground[i][j] = row.charAt(j);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visit[i][j]) bfs(i, j);
            }
        }

        System.out.println(W + " " + B);
    }
    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visit[x][y] = true;

        char friendly = battleground[x][y];

        int count = 1;

        while(!queue.isEmpty()) {
            int temp[] = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx > -1 && nx < N && ny > -1 && ny < M && battleground[nx][ny] == friendly && !visit[nx][ny]) {
                    count++;
                    visit[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        if(friendly == 'B') {
            B += (int) Math.pow(count, 2);
        }else {
            W += (int) Math.pow(count, 2);
        }
    }
}