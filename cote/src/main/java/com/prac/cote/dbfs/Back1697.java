package com.prac.cote.dbfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.MAX_VALUE;

@SpringBootApplication
public class Back1697 {
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1697.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N==K) {
            System.out.println(0);
        }else {
            bfs(N, K);
        }

    }

    public static void bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for(int i = 0; i < 3; i++) {
                int next;
                if(i == 0) {
                    next = now +1;
                }else if(i == 1) {
                    next = now -1;
                }else {
                    next = now * 2;
                }

                if(next == K) {
                    System.out.println(visited[now]);
                    return;
                }

                if(next >= 0 && next < visited.length && visited[next] == 0) {
                    queue.add(next);
                    visited[next] = visited[now] +1;
                }
            }
        }

    }
}