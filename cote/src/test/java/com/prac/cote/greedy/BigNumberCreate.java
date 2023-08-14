package com.prac.cote.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class BigNumberCreate {

	@Test
	public void test() {
		int k = 2;
		String number = "1924";

		String answer = "";

		StringBuilder sb = new StringBuilder();

		int index = 0;

		int start = 0;

		int end = number.length() - k;

		while(start < end) {
			int max = 0;
			for(int i = index; i < k + start + 1; i++) {
				int num = Integer.parseInt(String.valueOf(number.charAt(i)));
				if(num == 9) {
					max = num;
					index = i+1;
					break;
				}
				if(num > max) {
					max = num;
					index = i+1;
				}
			}
			sb.append(max);
			start++;
		}

		System.out.println(sb.toString());

		// for(int i = 0; i < del; i++) {
		// 	String num = "";
		// 	for(int j = i+1; j < del + 1; j++) {
		// 		num = String.valueOf(number.charAt(i));
		// 		for(int t = 0; t < del; t++) {
		// 			num += number.charAt(j+t);
		// 		}
		// 		System.out.println(num);
		// 		max = num == "" ? max : Math.max(max, Integer.parseInt(num));
		// 	}
		// }
	}
}
