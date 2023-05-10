package com.prac.cote.grid;

import java.util.Arrays;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int wating[] = new int[N];
		int result = 0;
		int temp = 0;
		for(int i = 0; i<N; i++) {
			wating[i] = sc.nextInt();
		}
		Arrays.sort(wating);
		for(int i=0; i<N; i++) {
			temp += wating[i];
			result += temp;
		}
		System.out.println(result);

	}

}