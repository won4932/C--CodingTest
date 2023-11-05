package com.prac.cote.dbfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back7562 {

    static int[] one = {-1, 1};
    static int[] two = {-2, 2};

    static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back7562.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for(int i = 0; i< TC; i++) {
            int l = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            if(x == ex && y == ey) {
                System.out.println(0);
            }else {
                System.out.println(bfs(x, y, ex, ey, l));
            }
        }
    }

    public static int bfs(int x, int y, int ex, int ey, int l) {
        boolean[][] visited = new boolean[l][l];
        int[][] chess = new int[l][l];

        Queue<int[]> queue = new LinkedList<>();

        visited[x][y] = true;

        queue.add(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] location = queue.poll();

            for(int i = 0; i< 8; i++) {
                int nx = location[0] + dx[i];
                int ny = location[1] + dy[i];

                if(nx > -1 && ny > -1 && nx < l && ny < l) {
                    if(!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        chess[nx][ny] = chess[location[0]][location[1]] +1;
                    }
                }
            }

//            for(int a = 0; a < 2; a++) {
//                for(int i = 0; i < 2; i++) {
//                    int nx;
//                    if(a==0) nx = location[0] + two[i];
//                    else nx = location[0] + one[i];
//
//                    for(int j = 0; j < 2; j++) {
//                        int ny;
//                        if(a==0) ny = location[1] + one[j];
//                        else ny = location[1] + two[j];
//                        if(nx > -1 && ny > -1 && nx < l && ny < l) {
//                            if(!visited[ny][nx] && chess[ny][nx] == 0) {
//                                visited[ny][nx] = true;
//
//                                queue.add(new int[]{nx, ny});
////
//                                chess[ny][nx] = chess[location[1]][location[0]] +1;
//                            }
//                        }
//                    }
//                }
//            }

        }

        return chess[ex][ey];
    }

}