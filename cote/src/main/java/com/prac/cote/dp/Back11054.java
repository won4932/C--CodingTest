package com.prac.cote.dp;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back11054 {

	static Integer[][] dp;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Back11054.class, args);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] coin = new int[n];

		int result = 0;

		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(st.nextToken());
		}

		int[] lis = new int[n];
		for(int a = 0; a < n; a++) {
			lis[a] = 1;
			for(int b = 0; b < a; b++) {
				if(coin[a] > coin[b]) lis[a] = Math.max(lis[b] + 1, lis[a]);
			}
		}

		int[] ris = new int[n];
		for(int a = n-1; a >= 0; a--) {
			ris[a] = 1;
			for(int b = n-1; b > a; b--) {
				if(coin[a] > coin[b]) ris[a] = Math.max(ris[b] + 1, ris[a]);
			}
		}

		for(int c = 0; c < n; c++) {
			result = Math.max(result, lis[c] + ris[c]);
		}

		System.out.println(result-1);
	}
}
