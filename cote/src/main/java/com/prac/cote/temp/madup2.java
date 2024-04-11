package com.prac.cote.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class madup2 {

    static int[][] area = {{1, 0, 0, 0, 1,},
                            {0, 0, 2, 0, 0},
                            {0, 2, 0, 1, 1},
                            {0, 0, 2, 0, 0},
                            {0, 0, 1, 0, 0}};
    static int rech = 2;

    static boolean[][] visited = new boolean[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int[] ints : area) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        System.out.println();

        for(int i = 0; i < area.length; i++) {
            for(int j = 0; j < area[i].length; j++) {
                if(area[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i-1, j, 0, true);
                    dfs(i+1, j, 0, true);
                    dfs(j-1, i, 0, false);
                    dfs(j+1, i, 0, false);
                }
            }
        }

        for (int[] ints : area) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }


    }

    static private void dfs(int a, int fix, int count, boolean xy) {
        if(count == rech) return;

        if(a < 5 && a > -1) {
            if(xy) {
                if(area[a][fix] == 0) {
                    visited[a][fix] = true;
                    area[a][fix] = 1;
                    dfs(a, fix, count+1, true);
                }
            }else {
                if(area[fix][a] == 0) {
                    visited[fix][a] = true;
                    area[fix][a] = 1;
                    dfs(a, fix, count+1, false);
                }
            }


        }
    }
}