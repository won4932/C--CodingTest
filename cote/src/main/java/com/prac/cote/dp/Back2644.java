package com.prac.cote.dp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back2644 {
    static boolean[] visited;

    static int answer = -1;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back2644.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        List<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 1; i <= N+1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        dfs(start, end, list, -1);

        System.out.println(answer);

    }

    public static void dfs(int start, int end, List<ArrayList<Integer>> list, int sum) {
        if(start == end) answer=sum+1;
        visited[start] = true;

        for (Integer i : list.get(start)) {
            if(!visited[i]) dfs(i, end, list, sum+1);
        }

    }
}