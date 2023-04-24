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
public class Back2138 {
	static int size, count = 0;
	static boolean[] before, after, copy;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String temp = "";
		size = N;
		before = new boolean[size];
		after = new boolean[size];
		copy = new boolean[size];
		temp = sc.next();
		for(int i=0; i<size; i++) {
			if(temp.charAt(i)=='1') {
				before[i] = true;
			}else {
				before[i] = false;
			}

		}
		temp = sc.next();
		for(int i=0; i<size; i++) {
			if(temp.charAt(i)=='1') {
				after[i] = true;
			}else {
				after[i] = false;
			}
		}
		go();


	}
	private static void go() {
		if(posible()) {
			System.out.println(count);
			return;
		}
		// 첫번쨰 누르고 시작
		change(1, false);
		count=1;
		if(posible()) {
			System.out.println(count);
			return;
		}
		System.out.println(-1);
	}
	private static boolean posible() {
		copy = before.clone();
		for(int i=1; i<size-1; i++) {
			if(copy[i-1]!= after[i-1]) {
				count++;
				change(i, true);
			}
		}
		if(copy[size-2]!= after[size-2]) {
			copy[size-2]= after[size-2];
			if(copy[size-1]) {
				copy[size-1] = false;
			}else {
				copy[size-1] = true;
			}
			count++;
		}
		for(int i = 0; i<size; i++) {
			if(copy[i]!= after[i]) return false;
		}
		return true;

	}
	private static void change(int index, boolean boo) {
		if(boo) { // 첫번쨰 안누를시
			for(int i = 0; i<3; i++) {
				if(copy[index-1 + i]) {
					copy[index-1 + i] = false;
				}else {
					copy[index-1 + i] = true;
				}
			}
		}else { // 누르고 시작
			for(int i = 0; i<2; i++) {
				if(before[index-1 + i]) {
					before[index-1 + i] = false;
				}else {
					before[index-1 + i] = true;
				}
			}
		}
	}
}