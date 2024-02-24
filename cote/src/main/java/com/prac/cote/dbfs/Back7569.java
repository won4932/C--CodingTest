package com.prac.cote.dbfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back7569 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] dz = {-1, 1};

    static int max = 0;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back7569.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        List<int[][]> boxes = new ArrayList<>();

        List<int[]> tomatoSee = new ArrayList<>();

        for(int i = 0; i < H; i++) {
            int[][] box = new int[N][M];
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                for(int a = 0; a < M; a++) {
                    int tomato = Integer.parseInt(st.nextToken());

                    box[j][a] = tomato;

                    if(tomato == 1) tomatoSee.add(new int[]{i, a, j});
                }
            }
            boxes.add(box);
        }
        bfs(tomatoSee, boxes, N, M, H);

        for (int[][] box : boxes) {
            for (int[] ints : box) {
                for (int anInt : ints) {
                    if(anInt == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        if(max == 0) System.out.println(0);
        else System.out.println(max-1);
    }

    public static void bfs(List<int[]> tomatoSee, List<int[][]> boxes, int N, int M, int H) {
        Queue<int[]> queue = new LinkedList<>();

        for (int[] ints : tomatoSee) {
            queue.add(ints);
        }

        while(!queue.isEmpty()) {
            int[] location = queue.poll();

            int nowz = location[0];
            int nowx = location[1];
            int nowy = location[2];

            System.out.println("z : " + nowz + " x : " + nowx + " y : " + nowy);

            for(int d = 0; d < 4; d++) {
                int nx = nowx + dx[d];
                int ny = nowy + dy[d];

                if(nx > -1 && ny > -1 && nx < M && ny < N) {
                    if(boxes.get(nowz)[ny][nx] == 0) {
                        queue.add(new int[]{nowz, nx, ny});

                        int tomorrow = boxes.get(nowz)[nowy][nowx] +1;

                        max = Math.max(max, tomorrow);

                        boxes.get(nowz)[ny][nx] = tomorrow;
                    }
                }
            }

            for(int a = 0; a < 2; a++) {
                int nz = nowz + dz[a];

                if(nz > -1 && nz < H) {
                    if(boxes.get(nz)[nowy][nowx] == 0) {
                        queue.add(new int[]{nz, nowx, nowy});

                        int tomorrow = boxes.get(nowz)[nowy][nowx] +1;

                        max = Math.max(max, tomorrow);

                        boxes.get(nz)[nowy][nowx] = tomorrow;
                    }
                }
            }

            for (int[][] box : boxes) {
                for (int[] ints : box) {
                    for (int anInt : ints) {
                        System.out.print(anInt + " ");
                    }
                    System.out.println();
                }
            }
        }


    }

}