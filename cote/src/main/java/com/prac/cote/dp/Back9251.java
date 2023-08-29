package com.prac.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back9251 {

	static Integer[][] dp;

	public static void main(String[] args) throws IOException {

		SpringApplication.run(Back9251.class, args);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// String lcs1 = br.readLine();
		// String lcs2 = br.readLine();

		char[] lcs1 = br.readLine().toCharArray();
		char[] lcs2 = br.readLine().toCharArray();


		dp = new Integer[lcs1.length][lcs2.length];

		System.out.println(dfs(lcs1.length-1, lcs2.length-1, lcs1, lcs2));
	}

	public static int dfs(int fi, int sec, char[] lcs1, char[] lcs2) {
		if(fi < 0 || sec < 0) return 0;

		if(dp[fi][sec]==null) {
			dp[fi][sec]=0;
			if(lcs1[fi] == lcs2[sec]) {
				dp[fi][sec] = dfs(fi-1, sec-1, lcs1, lcs2) + 1;
			}
			else {
				dp[fi][sec] = Math.max(dfs(fi-1, sec, lcs1, lcs2), dfs(fi, sec-1, lcs1, lcs2));
			}
		}

		return dp[fi][sec];
	}
}
