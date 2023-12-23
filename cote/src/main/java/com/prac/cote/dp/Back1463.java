package com.prac.cote.dp;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1463 {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        System.out.println(dp(N, 0));

    }

    public static int dp(int N, int count) {
        if(N < 2) return count;

        return Math.min(dp(N/3, count + 1 + (N % 3)), dp(N / 2, count + 1 + (N % 2)));

    }
}