package com.prac.cote.corporation;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back17471 {

    static int population[];

    static int N;

    static List<ArrayList<Integer>> area = new ArrayList<>();;

    static boolean ward[];

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        population = new int[N];
        ward = new boolean[N];

        for(int i = 0; i < N; i++) {
            area.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gu = Integer.parseInt(st.nextToken());

            for(int j = 0; j < gu; j++) {
                area.get(i).add(Integer.parseInt(st.nextToken()) -1);
            }
        }

        divide(0);

        if(result == Integer.MAX_VALUE) result = -1;
        System.out.println(result);
    }

    private static void divide(int idx) {
        if(idx == N) {
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();

            for(int i = 0; i < N; i++) {
                if(ward[i]) aList.add(i);
                else bList.add(i);
            }

            if(aList.size() == 0 || bList.size() == 0) return;

            if(check(aList) && check(bList)) {
                diff();
            }
            return;
        }

        ward[idx] = true;
        divide(idx + 1);
        ward[idx] = false;
        divide(idx + 1);
    }

    private static boolean check(List<Integer> list) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        visited[list.get(0)] = true;
        queue.add(list.get(0));

        int count = 1;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i = 0; i < area.get(now).size(); i++) {
                int nArea = area.get(now).get(i);
                if(list.contains(nArea) && !visited[nArea]) {
                    queue.add(nArea);
                    visited[nArea] = true;
                    count++;
                }
            }
        }

        if(count == list.size()) {
            return true;
        }else {
            return false;
        }
    }

    private static void diff() {
        int a = 0, b = 0;

        for(int i = 0; i < N; i++) {
            if(ward[i]) a += population[i];
            else b+= population[i];
        }

        result = Math.min(result, Math.abs(a - b));
    }
}