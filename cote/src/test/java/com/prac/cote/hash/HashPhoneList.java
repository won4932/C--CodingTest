package com.prac.cote.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HashPhoneList {

	@Test

	void muhong() {
		String[] phoen_book = {"12","123","1235","567","88"};

		List<String> prefix = new ArrayList<>();

		boolean ck = true;

		Arrays.sort(phoen_book);

		for(int i = 0; i<phoen_book.length; i++) {
			if(prefix.isEmpty()) {
				prefix.add(phoen_book[i]);
				continue;
			}

			for(String s : prefix) {
				if(phoen_book[i].contains(s)) {
					ck = false;
					break;
				}
			}
			if(ck) {
				prefix.add(phoen_book[i]);
			}else {
				break;
			}
		}

		System.out.println(ck);
	}

	@Test
	void test() {
		// String s = "abc";
		// System.out.println(s.substring(0, 1));

		// String[] ss = {"1", "2", "3"};
		//
		// System.out.println(ss.length);

		// HashMap<String, Integer> map = new HashMap<>();
		//
		// String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		//
		// for(String[] cloth : clothes) {
		// 	String type = cloth[1];
		// 	System.out.println(type);
		// 	map.put(type, map.getOrDefault(type, 0) + 1);
		// }
		//
		// Iterator<Integer> it = map.values().iterator();
		// int answer = 1;
		//
		// while(it.hasNext())
		//
		// 	System.out.println(it.next().intValue() + 1);

		String[] list = new String[1];

		String sp = "1,2,3";

		list = sp.split(",");

		// for(int i = 0; list.length; i++) {
		// 	list
		// }

		System.out.println(Integer.parseInt(list[2]));

		// for(String i : list) {
		// 	System.out.println(i);
		// }

	// 	List<Map.Entry<String, Integer>> entryList
	// 		= new LinkedList<>(sum.entrySet());
	// 	entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
	// 		@Override
	// 		public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
	// 			return o2.getValue() - o1.getValue();
	// 		}
	// 	});
	}
}
