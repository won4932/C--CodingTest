package com.prac.cote.dbfs;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back2210 {
    static String[][] digit;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static Set<String> str;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        digit = new String[5][5];

       str = new HashSet<>();

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                digit[i][j] = st.nextToken();
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
               dfs(i, j, digit[i][j]);
            }
        }

        str.forEach(System.out::println);

        System.out.println(str.size());
    }

    public static void dfs(int x, int y, String num) {
        if(num.length() == 6) {
            str.add((num));
            return;
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx > -1 && nx < 5 && ny > -1 && ny < 5) {
                dfs(nx, ny, num + digit[nx][ny]);
            }
        }
    }
}