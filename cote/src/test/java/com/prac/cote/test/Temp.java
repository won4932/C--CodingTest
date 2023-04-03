package com.prac.cote.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Temp {

	@Test
	public void test() {
		List<Integer> list = new ArrayList<>();

		List<Integer> list2 = new ArrayList<>();

		for(int i = 0; i < 22; i++) {
			list.add(i);
		}

		list2.add(999);
		list2.add(9999);
		list2.add(99999);

		list = list2;

		for (Integer integer : list) {
			System.out.println(integer);
		}


	}
}
