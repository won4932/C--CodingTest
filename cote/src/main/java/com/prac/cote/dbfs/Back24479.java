package com.prac.cote.dbfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back24479 {
    static int[] vistied;

    static List<Integer>[] list;

    static int cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        vistied = new int[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st= new StringTokenizer(br.readLine());

            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());

            list[com1].add(com2);
            list[com2].add(com1);
        }

        for (List<Integer> integers : list) {
            if(integers != null) Collections.sort(integers);
        }

        cnt = 1;

        dfs(start);

        for (int i = 1; i <= N; i++) {
            System.out.println(vistied[i]);
        }
    }

    public static void dfs(int com) {
        vistied[com] = cnt;

        for (Integer i : list[com]) {
            if(vistied[i] == 0) {
                cnt++;
                dfs(i);
            }
        }
    }
}