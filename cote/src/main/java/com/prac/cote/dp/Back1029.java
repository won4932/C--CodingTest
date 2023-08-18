package com.prac.cote.dp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

@SpringBootApplication
public class Back1029 {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1029.class, args);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        boolean[] visited = new boolean[t];

        String[] rawBuy = new String[t];

        int[][] buy = new int[t][t];

        for(int a = 0; a < t; a++) {
            rawBuy[a] = reader.readLine();
        }

        String[] rawBuy2 = Arrays.copyOfRange(rawBuy, 1, t);

        Arrays.sort(rawBuy2);

        buy[0] = Arrays.stream(rawBuy[0].split(""))
            .mapToInt(Integer::parseInt)
            .toArray();

        String[] test2 = rawBuy[0].split("");

        for(int i = 1; i < t; i++) {
            String[] temp = rawBuy2[i-1].split("");
            for(int j = 0; j < t; j++) {
                buy[i][j] = Integer.parseInt(temp[j]);
            }
        }

        dp(0, visited, buy, 1, 1);

        System.out.println(result);
    }

    public static void dp(int celler, boolean[] visited, int[][] buy, int depth, int price) {
        visited[celler] = true;

        if(depth == buy.length+1 || price == 9) {
            return;
        }

        for(int c = celler; c < buy.length; c++) {
            if(visited[c] || buy[celler][c] == 0 || buy[celler][c] < price) continue;

            result = Math.max(result, depth+1);
            dp(c, visited, buy, depth+1, buy[celler][c]);
        }

        visited[celler] = false;
    }
}
