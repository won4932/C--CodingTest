package com.prac.cote.dbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back14940 {
    static int T, storeCount;

    static int[] sanggeun, pantafort;

    static List<int[]> stores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            sanggeun = new int[2];
            stores = new LinkedList<>();
            pantafort = new int[2];

            storeCount = Integer.parseInt(br.readLine());

            st= new StringTokenizer(br.readLine());

            sanggeun[0] = Integer.parseInt(st.nextToken());
            sanggeun[1] = Integer.parseInt(st.nextToken());

            for(int j = 0; j < storeCount; j++) {
                st = new StringTokenizer(br.readLine());
                stores.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            st = new StringTokenizer(br.readLine());

            pantafort[0] = Integer.parseInt(st.nextToken());
            pantafort[1] = Integer.parseInt(st.nextToken());

            if(bfs(sanggeun[0], sanggeun[1])) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    public static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        var visited = new boolean[storeCount];

        while(!queue.isEmpty()) {
            int[] nxy = queue.poll();

            int nx = nxy[0];
            int ny = nxy[1];

            if(Math.abs(nx - pantafort[0]) + Math.abs(ny - pantafort[1]) <= 1000) {
                return true;
            }

            for(int i = 0; i < storeCount; i++) {
                if(!visited[i]) {
                    int sx = stores.get(i)[0];
                    int sy = stores.get(i)[1];
                    if(Math.abs(nx - sx) + Math.abs(ny - sy) <= 1000) {
                        visited[i] = true;
                        queue.add(new int[]{sx, sy});
                    }
                }

            }
        }

        return false;
    }

}