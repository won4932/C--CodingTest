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

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

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
                    dfs(i, j, 0, true);
                    dfs(i, j, 0, false);
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

        int ba = a - 1;
        int na = a + 1;

        if(ba < 5 && ba > 0 && fix < 5 && fix > 0) {
            if(xy) {
                if(area[ba][fix] == 0) {
                    area[ba][fix] = 1;
                    dfs(ba, fix, count+1, true);
                }
            }else {
                if(area[fix][ba] == 0) {
                    area[fix][ba] = 1;
                    dfs(ba, fix, count+1, false);
                }
            }


        }

        if(na < 5 && na > 0 && fix < 5 && fix > 0) {
            if(xy) {
                if(area[na][fix] == 0) {
                    area[na][fix] = 1;
                    dfs(na, fix, count+1, true);
                }
            }else {
                if(area[fix][na] == 0) {
                    area[fix][na] = 1;
                    dfs(na, fix, count+1, false);
                }
            }


        }


    }
}