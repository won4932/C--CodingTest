package com.prac.cote.stringSearch;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back14425 {
    static String N;
    static String M;

    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = br.readLine();
        M = br.readLine();

        dp = new Integer[N.length()][M.length()];

        System.out.println(dfs(N.length()-1, M.length()-1));

    }

    public static int dfs(int nIdx, int mIdx) {
        if(nIdx < 0 || mIdx < 0) return 0;

        if(dp[nIdx][mIdx] == null) {
            dp[nIdx][mIdx] = 0;
            if(N.charAt(nIdx) == M.charAt(mIdx)) {
                dp[nIdx][mIdx] = dfs(nIdx-1, mIdx-1) + 1;
            }else {
                dp[nIdx][mIdx] = Math.max(dfs(nIdx-1, mIdx), dfs(nIdx, mIdx-1));
            }
        }

        return dp[nIdx][mIdx];
    }
}