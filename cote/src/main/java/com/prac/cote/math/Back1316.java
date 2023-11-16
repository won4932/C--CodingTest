package com.prac.cote.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back1316 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int result = 0;

		// solution
		while(t-- > 0) {
			String input = br.readLine().trim();
			if(checkGroup(input)) {
				result++;
			}
		}

		System.out.print(result);
	}

	private static boolean checkGroup(String input) {
		boolean[] alpabet = new boolean[26];
		int length = input.length();

		int i;
		for(i=0; i<length; i++) {
			char temp = input.charAt(i);
			if(alpabet[temp-'a']) {
				// 이미 나온 단어
				return false;
			}else {
				if(i< length-1 && temp != input.charAt(i+1)) {
					alpabet[temp-'a'] = true;
				}

			}// end if
		}// end for

		return true;
	}
}