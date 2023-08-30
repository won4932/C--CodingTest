package com.prac.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back2293 {

	static Integer[][] dp;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Back2293.class, args);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coin = new int[n];

		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		dp = new Integer[coin.length][k+1];

		System.out.println(dfs(coin.length-1, k, coin));
	}

	public static int dfs(int i, int k, int[] coin) {
		if(i < 0 || k < 0) return 0;

		if(k == 0) dp[i][k] = 1;

			if(dp[i][k] == null) {
				dp[i][k] = 0;
				if(k < coin[i]) dp[i][k] = dfs(i-1, k, coin);
				else {
					dp[i][k] = dfs(i, k-coin[i], coin) + dfs(i-1, k, coin);
				}
			}



		return dp[i][k];
	}
}
