package com.prac.cote.dbfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back7576 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static boolean[][] visited;

    static int[][] tomato;

    static int max = 0;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back7576.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        tomato = new int[N][M];
        visited = new boolean[N][M];

        List<int[]> ripeTomatoes = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                int tomatoSee = Integer.parseInt(st.nextToken());
                tomato[i][j] = tomatoSee;
                if(tomatoSee == 1) {
                    ripeTomatoes.add(new int[]{i, j});
                }
            }

        }

        dfs(ripeTomatoes, N, M);

        for (int[] ints : tomato) {
            for (int anInt : ints) {
                if(anInt == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        if(max == 0) System.out.println(0);
        else System.out.println(max-1);
    }

    public static void dfs(List<int[]> ripeTomatoes, int N, int M) {
        Queue<int[]> que = new LinkedList<>();
        for (int[] ripeTomato : ripeTomatoes) {
            que.add(ripeTomato);
        }


        while(!que.isEmpty()) {
            int now[] = que.poll();
            for(int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if(nx > -1 && ny > -1 && nx < N && ny < M) {
                    if(tomato[nx][ny] == 0) {
                        que.add(new int[]{nx, ny});
                        int nextT = tomato[now[0]][now[1]] +1;
                        max = Math.max(max, nextT);
                        tomato[nx][ny] = nextT;
                    }
                }
            }
        }
    }
}