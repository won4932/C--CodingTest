package com.prac.cote.dbfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;

@SpringBootApplication
public class Back2178 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer = 0;

    static boolean[][] visited;

    static int[][] miro;

    static  int result = MAX_VALUE;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back2178.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        miro = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String road = br.readLine();

            miro[i] = Arrays.stream(road.split("")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(0, 0, N, M);

        visited[0][0] = true;

        System.out.println(miro[N-1][M-1]);
    }

    public static void dfs(int x, int y, int N, int M) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});

        while(!que.isEmpty()) {
            int now[] = que.poll();
            for(int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if(nx > -1 && ny > -1 && nx < N && ny < M) {
                    if(miro[nx][ny] == 1 && !visited[nx][ny]) {
                        que.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        miro[nx][ny] = miro[now[0]][now[1]] +1;
                    }
                }
            }
        }
    }
}