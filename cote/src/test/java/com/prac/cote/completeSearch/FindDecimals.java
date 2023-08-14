package com.prac.cote.completeSearch;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class FindDecimals {

	private static Set<Integer> set = new HashSet<>();
	private static String[] ch;
	private static boolean[] ck;

	@Test
	public void test() {
		String x = "289";

		ch = new String[x.length()];
		ck = new boolean[x.length()];

		ch = x.split("");

		// search("", 0);
		System.out.println(decimalDistinc(2));

		System.out.println(set.size());
	}

	public void search(String str, int index) {
		Integer num;

		if(str != "") {
			num = Integer.parseInt(str);
			if(decimalDistinc(num)) {
				System.out.println(num);
				set.add(num);
			}
		}

		if(index==ch.length) return;

		for(int i = 0; i < ch.length; i++) {
			if(ck[i]) continue;
			ck[i] = true;
			search(String.format("%s%s", str, ch[i]), index+1);
			ck[i] =false;
		}
	}

	public boolean decimalDistinc(int num) {
		for(int i = 2; i < Math.round(Math.sqrt(num)) +1; i++) {
			System.out.println("??????");
			if(num % i == 0) {
				return false;
			}
		}
		return num == 1 || num == 0 ? false : true;
	}
}
