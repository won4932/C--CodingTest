package com.prac.cote.dbfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back1926 {

    static int[] dx = {-1, 0, 1, 0};

    static int[] dy = {0, -1, 0, 1};

    static boolean[] vistied;

    static int answer = 0;


    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1926.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] picture = new int[N][M];

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            picture[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j< M; j++) {
                if(picture[i][j] == 1) {
                    answer =0 ;
                    dfs(i, j, picture, N, M);
                    list.add(answer);
                }
            }
        }

        System.out.println(list.size());
        if(list.isEmpty()) System.out.println(0);
        else System.out.println(Collections.max(list));
    }

    public static void dfs(int x, int y, int[][] picture, int N, int M) {
        picture[x][y] = 0;
        answer++;

        for(int d = 0; d < 4; d++) {
            int a = x + dx[d];
            int b = y + dy[d];
            if(a > -1 && b > -1 && a < N && b < M) {
                if(picture[a][b] == 1) {
                    dfs(a, b, picture, N, M);
                }
            }
        }
    }
}