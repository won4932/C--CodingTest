package com.prac.cote.dbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Back18352 {
    static int N, M, K, X;

    static boolean[] visited;

    static List<ArrayList<Integer>> cities;
    static Set<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];

        cities = new ArrayList<>();
        result = new HashSet<>();

        for(int i = 0; i < N+1; i++) {
            cities.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int cityA = Integer.parseInt(st.nextToken());
            int cityB = Integer.parseInt(st.nextToken());

            cities.get(cityA).add(cityB);
        }

        bfs(X);

        if(result.isEmpty()) {
            System.out.println(-1);
        }else {
            result.stream().sorted().forEach(System.out::println);
        }

    }

    public static void bfs(int idx) {
        Queue<City> queue = new LinkedList<>();
        queue.add(new City(idx, 0));
        visited[idx] = true;

        while(!queue.isEmpty()) {
            City city = queue.poll();

            if(city.count > K) break;

            if(city.count == K) result.add(city.now);

            for (Integer i : cities.get(city.now)) {

                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(new City(i, city.count+1));
                }

            }
        }

    }

    public static class City {
        int now;
        int count;
        public City(int now, int count) {
            this.now = now;
            this.count = count;
        }
    }
}