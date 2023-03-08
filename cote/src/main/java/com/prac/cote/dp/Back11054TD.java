package com.prac.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back11054TD {

	static Integer[][] dp;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Back11054TD.class, args);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] coin = new int[n];

		int result = 0;

		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(st.nextToken());
		}

		Integer[] lis = new Integer[n];
		Integer[] ris = new Integer[n];

		for(int i = 0; i < n; i++) {
			lds(i, lis, coin);
			rds(i, ris, coin);
		}

		for(int c = 0; c < n; c++) {
			result = Math.max(result, lis[c] + ris[c]);
		}

		System.out.println(result-1);
	}

	public static int lds(int i, Integer[] lis, int[] coin) {
		if (lis[i] == null) {
			lis[i] = 1;
			for(int a = i-1; a >= 0; a--) {
				if(coin[i] > coin[a]) lis[i] = Math.max(lds(a, lis, coin) + 1, lis[i]);
			}
		}

		return lis[i];
	}

	public static int rds(int i, Integer[] ris, int[] coin) {
		if(ris[i] == null) {
			ris[i] = 1;
			for(int a = i+1; a < ris.length; a++) {
				if(coin[i] > coin[a]) ris[i] = Math.max(rds(a, ris, coin) + 1, ris[i]);
			}
		}


		return ris[i];
	}

}
