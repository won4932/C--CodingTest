package com.prac.cote.dbfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back5014 {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back5014.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            String inputLine = br.readLine();
            if (inputLine.equals("00") || inputLine.equals("0 0")) break;

            st = new StringTokenizer(inputLine, " ");

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            int[][] map;
            map = new int[h][w];

            for(int i = 0; i < h; i++) {
                String island = br.readLine();
                map[i] = Arrays.stream(island.split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int answer = 0;

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] == 1) {
                        answer++;
                        dfs(i, j, map, w, h);
                    }
                }
            }

            System.out.println(answer);
        }

    }

    public static void dfs(int x, int y, int[][] map, int w, int h) {
        map[x][y] = 0;

        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                int a = x + j;
                int b = y + i;
                if(a > -1 && b > -1 && a < h && b < w) {
                    if(map[a][b] == 1) dfs(a, b, map, w, h);
                }
            }
        }
    }
}