package com.prac.cote.dbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back11060 {
    static int N;

    static int[] miro;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            miro[i] = Integer.parseInt(st.nextToken());
        }

        bfs(0);

    }

    public static int bfs(int idx) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(idx, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            int now = node.idx;

            if(now == N-1) return node.count;

            for(int i = now + 1; i < miro[now]; i++) {
                if(i > N -1) break;
                queue.add(new Node(i, node.count+1));
            }
        }

        return -1;
    }

    static class Node {
        int idx;
        int count;

        Node(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }

}