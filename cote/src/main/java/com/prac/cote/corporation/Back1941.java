package com.prac.cote.corporation;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
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

    static char[][] student;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        student = new char[5][5];


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
        boolean[][] cpyVisited = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            cpyVisited[i] = visited[i].clone();
        }

        int x = 0, y = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (cpyVisited[i][j]) {
                    x = i;
                    y = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        Point p = new Point(x, y);

        int cnt = 0;
        int ids = 0;
        while(!queue.isEmpty()) {
            int[] coordinate = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = coordinate[0] + dx[i];
                int ny = coordinate[1] + dy[i];

                if(0 > nx || 5 <= nx || 0 > ny || 5 <= ny) continue;

                if(cpyVisited[nx][ny]) {
                    if(student[nx][ny] == 'S') ids++;
                    cnt++;
                    queue.add(new int[]{nx, ny});
                    cpyVisited[nx][ny] = false;
                }
            }
        }

        if(cnt == 7 && 4 <= ids) {
            return true;
        }

        return false;
    }
}