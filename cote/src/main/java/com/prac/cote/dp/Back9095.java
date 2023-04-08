package com.prac.cote.dp;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back9095 {
	// Bottom-up
	public static void main(String[] args) {
		int[] dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();

			for(int j =4; j<=N; j++) {
				dp[j] = dp[j-1]+ dp[j-2] + dp[j-3];
			}
			System.out.println(dp[N]);
		}
	}
}
