package com.prac.cote.dbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back13023 {
    static ArrayList<ArrayList<Integer>> friend;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        friend = new ArrayList<>();
        for(int i=0; i<N; i++) {
            friend.add(new ArrayList<Integer>());
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friend.get(a).add(b);
            friend.get(b).add(a);

        }
        for(int i=0; i<N; i++) {
            visit = new boolean[N];
            if(dfs(i, 1)) {
                System.out.println("1");
                return;
            }
        }
        System.out.println("0");
    }
    private static boolean dfs(int now, int depth) {
        if(depth==5) return true;

        visit[now] = true;
        for(int i : friend.get(now)) {
            if(visit[i]) continue;
            if(dfs(i, depth+1)) return true;
        }
        visit[now] = false;
        return false;
    }
}