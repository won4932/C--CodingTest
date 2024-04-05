package com.prac.cote.dbfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back1389 {
    static int min = Integer.MAX_VALUE;

    static int[] users;

    static int N, M;

    static List<ArrayList<Integer>> relation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        users = new int[N+1];
//        vistied = new boolean[N+1][N+1];

        relation = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            relation.add(new ArrayList<>());
        }

        for(int i = 1; i <= M; i++) {
            st= new StringTokenizer(br.readLine());

            int userA = Integer.parseInt(st.nextToken());
            int userB = Integer.parseInt(st.nextToken());

            relation.get(userA).add(userB);
            relation.get(userB).add(userA);
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i != j) {
                    users[i] += bfs(i, j);
                }
            }
        }

        int index = 1;

        for(int i = 1; i <= N; i++) {
            if(min > users[i]) {
                min = users[i];
                index = i;
            }
        }

        System.out.println(index);

    }

    public static int bfs(int user, int friend) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(user);

        boolean[] visited = new boolean[N+1];
        int[] userCount = new int[N+1];

        visited[user] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if(now == friend) {
                return userCount[now];
            }

            for (Integer i : relation.get(now)) {
                if(!visited[i]) {
                    visited[i] = true;
                    userCount[i] = userCount[now] + 1;
                    queue.add(i);
                }
            }
        }
        return 0;
    }

    public static class User {
        int user;
        int rel;

        public User(int user, int rel) {
            this.user = user;
            this.rel = rel;
        }
    }
}