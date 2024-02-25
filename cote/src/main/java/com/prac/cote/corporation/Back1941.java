package com.prac.cote.corporation;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1941 {

    static int result = 0;
    static boolean[][] visited = new boolean[5][5];

    static int[][] student;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        student = new int[5][5];


        for(int i = 0 ; i < 5; i++) {
            String schoolgirl = br.readLine();

            for(int j = 0; j < 5; j++) {
                student[i][j] = schoolgirl.charAt(j);
            }
        }

        dfs(0, 0);

        System.out.println(result);
    }

    private static void dfs(int depth, int idx) {
        if(idx == 7) {
            if (checkPrincess()) result++;
        }else {
            for(int i = idx; i < 25; i++) {
                visited[i / 5][i % 5] = true;
                dfs(depth+1, i+1);
                visited[i / 5][i % 5] = false;
            }
        }
    }

    private static boolean checkPrincess() {
        Queue<Integer> queue = new LinkedList<>();


    }
}