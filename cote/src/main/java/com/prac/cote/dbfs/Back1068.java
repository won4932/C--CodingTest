package com.prac.cote.dbfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1068 {

    static boolean[] vistied;

    static int answer = 0;


    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1068.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        vistied = new boolean[N];

        List<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        String nodes = br.readLine();
        st = new StringTokenizer(nodes, " ");

        int root = 0;

        for(int i = 0; i< N; i++) {
            int node = Integer.parseInt(st.nextToken());

            if(node == -1) {
                root = i;
                continue;
            }

            list.get(i).add(node);
            list.get(node).add(i);
        }

        int remove = Integer.parseInt(br.readLine());

        if(remove != root) dfs(root, list, remove);

        System.out.println(answer);
    }

    public static void dfs(int node, List<ArrayList<Integer>> list, int remove) {
        vistied[node] = true;

        int child = 0;

        for (Integer i : list.get(node)) {
            if(i != remove && !vistied[i]) {
                child++;
                dfs(i, list, remove);
            }
        }

        if(child == 0) answer++;
    }
}