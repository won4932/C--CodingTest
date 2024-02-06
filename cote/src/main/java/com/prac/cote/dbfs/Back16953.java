package com.prac.cote.dbfs;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back16953 {
    static int min = Integer.MAX_VALUE;

    static int A, B;
    //    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

//        visited = new boolean[100001];

        bfs();

        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(A, 1));

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            if(n.x == B) min = Math.min(min, n.time);

            if(n.x * 2 <= B) queue.add(new Node(n.x * 2, n.time + 1));
            if(String.valueOf(n.x).length() < 9 && String.valueOf(n.x).length() < String.valueOf(B).length()) queue.add(new Node(Integer.parseInt(n.x + "1"), n.time + 1));
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