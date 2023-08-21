package com.prac.cote.dp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class Back1053 {

    public static void main(String[] args) throws IOException {

        SpringApplication.run(Back1053.class, args);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();

        int result = dfs(str);

        String strT;

        for(int d = 0; d < str.length(); d++) {
            for(int e = d + 1; e < str.length() -1; e++) {
                if(str.charAt(d) == str.charAt(e)) continue;
                strT = swap(d, e, str);
                result = Math.min(result, dfs(strT) + 1);
            }
        }
        System.out.println(result);

    }

    public static int dfs(String str) {
        int size = str.length();
        int[][] dp = new int[size][size];

        for(int a = 0; a < size; a++) {
            dp[a][a] = 0;
            if(a != size -1) {
                dp[a][a+1] = str.charAt(a) == str.charAt(a+1) ? 0 : 1;
            }
        }

        for(int b = 2; b < size; b++) {
            for(int c = 0; c < size - b; c++) {
                dp[c][c+b] = Math.min(dp[c+1][c+b] +1, dp[c][c+b-1] +1);
                if(str.charAt(c) == str.charAt(c + b)) {
                    dp[c][c+b] = Math.min(dp[c+1][c+b-1], dp[c][c+b]);
                }else {
                    dp[c][c+b] = Math.min(dp[c+1][c+b-1] + 1, dp[c][c+b]);
                }
            }
        }
    return dp[0][size-1];
    }

    public static String swap(int f, int b, String strT) {
        StringBuilder sb = new StringBuilder(strT);
        char temp = strT.charAt(f);
        sb.setCharAt(f, strT.charAt(b));
        sb.setCharAt(b, temp);
        return sb.toString();
    }
}