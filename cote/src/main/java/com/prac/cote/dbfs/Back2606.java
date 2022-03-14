package com.prac.cote.dbfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back2606 {
    static boolean [] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back2606.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] computer;

        int computerCount = Integer.parseInt(br.readLine());

        visited = new boolean[computerCount+1];

        computer = new int[computerCount+1][computerCount+1];

        int computerConn = Integer.parseInt(br.readLine());

        for(int i = 0; i < computerConn; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            computer[f][s] = 1;
            computer[s][f] = 1;
        }
        dfs(1, computerCount, computer);

        System.out.println(answer-1);
    }

    public static void dfs(int comNum, int computerCount, int[][] computer) {
        visited[comNum] = true;
        answer++;

        for(int i = 1; i <= computerCount; i++) {
            if(!visited[i] && computer[comNum][i]==1) {
                dfs(i, computerCount, computer);
            }
        }
    }
}