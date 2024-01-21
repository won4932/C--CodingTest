package com.prac.cote.dp;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1912 {
    static Integer[] dp;
    static int[][] triangle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        triangle = new int[n+1][n+1];

        for(int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        int answer = 0;
        int[][] temp = new int[triangle.length][triangle[triangle.length-1].length];
        temp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            temp[i][0] = temp[i - 1][0] + triangle[i][0];
            temp[i][i] = temp[i - 1][i - 1] + triangle[i][i];
            for (int j = 1; j <= i-1; j++) {
                temp[i][j] = Math.max(temp[i - 1][j - 1], temp[i - 1][j]) + triangle[i][j];
                answer = Math.max(answer, temp[i][j]);
            }
        }

        System.out.println(answer);
    }

    public static int dp(int N) {
        if(dp[N] == null) {

        }
        return dp[N];
    }
}