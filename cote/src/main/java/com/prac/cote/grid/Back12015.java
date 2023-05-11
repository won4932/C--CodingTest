package com.prac.cote.grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back12015 {

	static int N=0;
	static int sequence[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sequence = new int[N];
		int result = 1;
		String s[] = br.readLine().split(" ");

		for(int i = 0; i<N; i++) {
			sequence[i] = Integer.parseInt(s[i]);
		}

		Arrays.sort(sequence);
		int index = sequence[0];
		for(int i : sequence) {
			if(index<i) {
				index = i;
				result++;
			}
		}
		System.out.println(result);
		//	for(int i : sequence) System.out.print(i + " ");
	}

}