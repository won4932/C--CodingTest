package com.prac.cote.grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back1285 {
	static int count = 0;
	static boolean[][] coin;
	static boolean[] row;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		coin = new boolean[N][N];
		row = new boolean[N];
		String temp = "";
		for(int i = 0; i<N; i++) {
			temp = sc.next();
			for(int j = 0; j<N; j++) {
				if(temp.charAt(j)=='T') {
					coin[i][j]=true;
				}else{
					coin[i][j]=false;
				}
			}
		}
		simulation();
	}
	private static void simulation() {
		int result = N*N;
		int cases = (int) Math.pow(2, N)-1;
		for(int i = 0; i<cases; i++) {
			int sum = 0;
			String num = Integer.toBinaryString(i);
			trans(num);
			for(int j = 0; j<N; j++) {
				int nowT = 0;
				for(int k = 0; k<N; k++) {
					boolean now = coin[k][j];
					if(row[k]) {
						if(now) now = false;
						else now = true;
						//						System.out.println("flip!");
					}
					if(now) nowT++;
					//					System.out.println(k + " " + j + " " + now + " " + nowT);
				}
				sum += Math.min(nowT, N-nowT);
			}
			result = Math.min(result, sum);

		}
		System.out.println(result);
	}
	private static void trans(String nowRow) {
		while(nowRow.length()<N) {
			nowRow = "0" + nowRow;
		}
		for(int i = 0; i<N; i++) {
			char temp = nowRow.charAt(i);
			if(temp=='1') {
				row[N-i-1] = true;
			}else {
				row[N-i-1] = false;
			}
		}
	}
}