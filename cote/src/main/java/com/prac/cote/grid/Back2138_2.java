package com.prac.cote.grid;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back2138_2 {
		static int[] before;
		static int[] after;
		static int[] paste;
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			before = new int[N];
			after = new int[N];
			paste = new int[N];
			String temp = "";
			int result = 0;
			int result2 = 0;


			temp = sc.next();
			for(int j=0; j<N; j++) {
				before[j] = temp.charAt(j)-'0';
			}
			temp = sc.next();
			for(int j=0; j<N; j++) {
				after[j] = temp.charAt(j)-'0';
			}

			paste = before.clone();
			paste[0] = 1-paste[0];
			paste[1] = 1-paste[1];

			result = push(paste, 1);
			result2 = push(before, 0);
			if(result == -1) result = result2;


			System.out.println(result);




		}


		public static int push(int temp[], int sw) {
			int count = sw;
			for(int i = 1; i<temp.length-1; i++) {
				if(temp[i-1]!=after[i-1]) {
					count++;
					temp[i] = 1-temp[i];
					temp[i-1] = 1-temp[i-1];
					temp[i+1] = 1-temp[i+1];
				}

			}
			if(temp[temp.length-2]!=after[temp.length-2]) {
				count++;
				temp[temp.length-2] = 1-temp[temp.length-2];
				temp[temp.length-1] = 1-temp[temp.length-1];
			}

			for(int i=0; i<temp.length; i++) {
				if(temp[i]!=after[i]) count = -1;
			}
			return count;
		}

}