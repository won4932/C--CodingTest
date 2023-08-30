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

		int result = 1;

		int min = 0;
		int max = 0;

		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(st.nextToken());
		}

		for(int a = 0; a < n; a++) {
			if(a < n/2) {
				if (coin[a] < coin[n/2] && coin[a] > min) {
					System.out.println("MIN : " + coin[a] + ",  " + min);
					min = coin[a];
					result++;
				}
			}else if(a > n/2){
				if (coin[a] > coin[n/2] && coin[a] < max) {
					System.out.println("MAX : " + coin[a] + ",  " + max);
					max = coin[a];
					result++;
				}
			}
		}

		System.out.println(result);
	}
}
