package com.prac.cote.dbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Back9205 {
    static int T, storeCount;

    static int[] sanggeun, pantafort;

    static List<int[]> stores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sanggeun = new int[2];
        stores = new LinkedList<>();
        pantafort = new int[2];

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
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
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 20));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            int nx = node.x;
            int ny = node.y;
            int nBear = node.bear;

            System.out.println(nx + " : " + ny + ", " + nBear);

            if(node.bear < 0) {
                break;
            }

            if(nx == pantafort[0] && ny == pantafort[1]) {
                return true;
            }

            for (int[] store : stores) {
                if(nx == store[0] && ny == store[1]) {
                    nBear = 20;
                }
            }

            if(nx < pantafort[0]) {
                nx = nx+50;
                nBear = nBear-1;
            }else if(nx > pantafort[0]) {
                nx = nx-50;
                nBear = nBear-1;
            }

            if(ny < pantafort[1]) {
                ny = ny+50;
                nBear = nBear-1;
            }else if(ny > pantafort[1]) {
                ny = ny-50;
                nBear = nBear-1;
            }
            queue.add(new Node(nx, ny, nBear));

        }

        return false;
    }

    public static class Node {
        int x;
        int y;

        int bear;
        public Node(int x, int y, int bear) {
            this.x = x;
            this.y = y;
            this.bear = bear;
        }
    }
}