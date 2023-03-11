package com.prac.cote.dp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back11725 {

    static boolean[] visited;

    static int[] result;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back11725.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        result = new int[N+1];

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            list.get(parent).add(child);
            list.get(child).add(parent);
        }

        for(int i = 1; i < N+1; i++) {
            bfs(i, list);
        }

        for(int i = 2; i < N+1; i++) {
            System.out.println(result[i]);
        }

    }

    public static void bfs(int i, List<List<Integer>> list) {
        visited[i] = true;

        for (Integer integer : list.get(i)) {
            if(!visited[integer]) {
                result[integer] = i;
                bfs(integer, list);
            }

        }
    }
}