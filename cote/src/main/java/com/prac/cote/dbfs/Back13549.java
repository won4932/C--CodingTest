package com.prac.cote.dbfs;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back13549 {
    static int min = Integer.MAX_VALUE;

    static int subin, sister;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        sister = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        bfs();

        System.out.println(min);
    }
    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(subin, 0));

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            visited[n.x] = true;

            if(n.x == sister) min = Math.min(min, n.time);

            if(n.x * 2 <= 10000 && !visited[n.x * 2]) queue.add(new Node(n.x * 2, n.time));
            if(n.x + 1 <= 10000 && !visited[n.x + 1]) queue.add(new Node(n.x + 1, n.time + 1));
            if(n.x - 1 >= 0 && !visited[n.x - 1]) queue.add(new Node(n.x - 1, n.time + 1));

        }
    }

    public static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}