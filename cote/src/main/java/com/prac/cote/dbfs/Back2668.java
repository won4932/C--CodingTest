package com.prac.cote.dbfs;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back2668 {
    static int N;

    static int[] list;

    static boolean[] visited;

    static ArrayList<Integer> cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        cnt = new ArrayList<>();
        list = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <=N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(cnt);
        System.out.println(cnt.size());
        for(int i = 0; i < cnt.size(); i++) {
            System.out.println(cnt.get(i));
        }
    }

    public static void dfs(int start, int target) {
        int nt = list[start];
        if(!visited[nt]) {
            visited[nt] = true;
            dfs(nt, target);
            visited[nt] = false;
        }
        if(nt == target) cnt.add(target);
    }
}