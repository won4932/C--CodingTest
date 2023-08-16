package com.prac.cote.dp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1029 {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1029.class, args);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        boolean[] visited = new boolean[t];

        String[] buy = new String[t];

        for(int a = 0; a < t; a++) {
            buy[a] = reader.readLine();
        }

        for(int b = 0; b < buy.length; b++) {
            visited[b] = true;

        }
    }

    public void dp() {

    }
}
