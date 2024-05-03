package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back1707 {
    static int[] colors;

    static int T, V, E;

    static List<ArrayList<Integer>> graph;

    static boolean ck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            st= new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();

            colors = new int[V+1];

            ck = true;

            for(int j = 0; j  <= V; j++) {
                graph.add(new ArrayList<>());
            }

            for(int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            for(int j = 1; j <= V; j++) {
                if(!ck) break;

                if(colors[j] == 0) {
                    bfs(j);
                }
            }

            System.out.println(ck ? "YES" : "NO");
        }


    }

    private static void bfs(int idx) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        colors[idx] = -1;

        while(!queue.isEmpty()) {
            int nIdx = queue.poll();

            for (Integer i : graph.get(nIdx)) {
                if(colors[i] == 0) {
                    queue.add(i);
                    colors[i] = colors[nIdx] * -1;
                }else if(colors[nIdx] + colors[i] != 0) {
                    ck = false;
                    return;
                }
            }
        }



	}

    public static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}