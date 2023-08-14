package com.prac.cote.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BiggestNumber {

	@Test
	public void solution() {
		int[] op2 = {6, 10, 2}; // 6210
		int[] op3 = {3, 30, 34, 5, 9, 31, 2}; // 9534330
		int[] op = {12, 1213}; // 9534330

		String s = "";

		StringBuilder sb = new StringBuilder();

		Arrays.stream(op)
			.boxed()
			.collect(Collectors.toList())
			.sort((a,b) -> {
				String as = String.valueOf(a);
				String bs = String.valueOf(b);
				return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
			});

		String[] str = new String[op.length];

		for(int i = 0; i < op.length; i++) {
			str[i] = String.valueOf(op[i]);
		}

		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o2.compareTo(o1);
				}
				if(o1.charAt(0) == o2.charAt(0)) {
					int lengMax = o1.length() <= o2.length() ? o2.length() : o1.length();

					int o1Comapre = 0;
					int o2Comapre = 0;

					for(int i = 0; i < lengMax; i++) {
						if(i >= o1.length()) o1Comapre+= (int)o1.charAt(0);
						else o1Comapre += (int)o1.charAt(i);
						if(i >= o2.length()) o2Comapre+= (int)o2.charAt(0);
						else o2Comapre += (int)o2.charAt(i);

					}
					return o2Comapre - o1Comapre;
				}
				return o2.compareTo(o1);
			}
		});

		for (String s1 : str) {
			if(str[0].equals("0")) {
				s+= "0";
				break;
			}
			s+= s1;
		}
		System.out.println(s);
	}
}
