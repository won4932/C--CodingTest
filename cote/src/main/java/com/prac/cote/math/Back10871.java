package com.prac.cote.math;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back10871 {
	public static void main(String[] args) {
		int[] A;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		A = new int[N];
		for(int i=0; i<A.length; i++) {
			A[i] = sc.nextInt();
		}
		for(int i=0; i<A.length; i++) {
			if(A[i] <X) {
				System.out.print(A[i]+ " ");
			}
		}

	}
}