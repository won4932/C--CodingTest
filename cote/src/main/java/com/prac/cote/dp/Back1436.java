package com.prac.cote.dp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1436 {

    static ArrayList<Integer>[] seq;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1436.class, args);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        for(int i = 0; i < t; i++) {
            StringTokenizer st;
            st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(reader.readLine());

            long[] building = new long[n+1];
            seq = new ArrayList[n+1];
            int[] ck = new int[n+1];

            for(int a = 1; a < n + 1; a++) {
                building[a] = Long.parseLong(st.nextToken());
                seq[a] = new ArrayList<>();
            }

            for(int a = 0; a < k; a++) {
                StringTokenizer st2 = new StringTokenizer(reader.readLine());

                int start = Integer.parseInt(st2.nextToken());
                int end = Integer.parseInt(st2.nextToken());

                seq[start].add(end);

                ck[end]++;
            }

            int w = Integer.parseInt(reader.readLine());

            long[] time = new long[n+1];

            bfs(time, building, ck);

            System.out.println(time[w]);
        }
    }

    public static void bfs(long[] time, long[] building, int[] ck) {
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < ck.length; i++) {
            if(ck[i] == 0) {
                time[i] = building[i];
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int i = 0; i < seq[current].size(); i++) {
                int next = seq[current].get(i);
                time[next] = Math.max(time[current] + building[next], time[next]);
                ck[next]--;
                if(ck[next] == 0) queue.add(next);
            }
        }
    }
}
