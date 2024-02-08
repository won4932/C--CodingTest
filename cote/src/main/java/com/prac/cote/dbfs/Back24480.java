package com.prac.cote.dbfs;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back24480 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visit;

    static int[] result;

    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];
        result = new int[N+1];

        graph = new ArrayList<>();

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (ArrayList<Integer> integers : graph) {
            Collections.sort(integers, Collections.reverseOrder());
        }

        dfs(R);

        for(int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }

    }
    private static void dfs(int depth) {
        result[depth] = count++;
        visit[depth] = true;

        for (Integer i : graph.get(depth)) {
            if(!visit[i]) {
                dfs(i);
            }
        }

    }
}