package com.prac.cote.dp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back2667 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static ArrayList<Integer> house = new ArrayList<>();
    static int answer;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back2667.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] complex;

        int N = Integer.parseInt(br.readLine());

        complex = new int[N][N];

        for(int i = 0; i < N; i++) {
            String houses = br.readLine();

            complex[i] = Arrays.stream(houses.split("")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                answer = 0;
                dfs(i, j, complex, N);
                if(answer != 0) house.add(answer);
            }
        }

        System.out.println(house.size());
        Collections.sort(house);
        for (Integer i : house) {
            System.out.println(i);
        }
    }

    public static void dfs(int x, int y, int[][] complex, int N) {
        if(complex[x][y] == 1) {
            answer++;
            complex[x][y] = 0;
            for(int d = 0; d < 4; d++) {
                if(x + dx[d] > -1 && y + dy[d] > -1 && x + dx[d] < N && y + dy[d] < N) {
                    if(complex[x+dx[d]][y+dy[d]] == 1) {
                        dfs(x + dx[d], y + dy[d], complex, N);
                    }
                }
            }
        }
    }
}