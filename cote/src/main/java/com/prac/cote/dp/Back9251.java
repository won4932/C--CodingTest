package com.prac.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back9251 {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(Back9251.class, args);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String lcs1 = br.readLine();
		String lcs2 = br.readLine();

		int[][] dp = new int[lcs1.length()][lcs2.length()];

		int result = 0;

		for(int i = lcs1.length()-1; i > 0; i--) {
			result = Math.max(result, dfs(i, lcs2.length()-1, lcs1, lcs2, lcs2.length()-1, new int[lcs1.length()][lcs2.length()]));
		}
		System.out.println(result);
		// System.out.println(dfs(lcs1.length()-1, lcs2.length()-1, lcs1, lcs2, lcs2.length()-1));
	}

	public static int dfs(int fi, int sec, String lcs1, String lcs2, int secEnd, int[][] dp) {
		System.out.println(fi + " : " + sec + " , " + secEnd);
		if(fi < 0) return 0;

		if(sec < 0) return dfs(fi-1, secEnd, lcs1, lcs2, secEnd, dp);

		if(dp[fi][sec] == 0) {
			if(lcs1.charAt(fi) != lcs2.charAt(sec)) dp[fi][sec] = dfs(fi, sec-1, lcs1, lcs2, secEnd, dp);
			else {
				dp[fi][sec] = Math.max(dfs(fi, sec-1, lcs1, lcs2, sec-1, dp), dfs(fi-1, sec-1, lcs1, lcs2, sec-1, dp)) + 1;
			}
		}

		return dp[fi][sec];
	}
}
