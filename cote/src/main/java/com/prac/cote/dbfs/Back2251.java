package com.prac.cote.dbfs;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back2251 {
    static boolean[][] vistied;
    static boolean[] answer;

    static int A, B, C;

    static int[] sender = {0 ,0 , 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        vistied = new boolean[201][201];
        answer = new boolean[201];

        bfs();
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        vistied[0][0] = true;
        answer[C] = true;

        while(!queue.isEmpty()) {
            int[] ab = queue.poll();
            int c = C - ab[0] - ab[1];

            for(int i = 0; i < 6; i++) {
                int[] next = {ab[0], ab[1], c};

                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;

                if(next[receiver[i]] > )

            }
        }
    }
}