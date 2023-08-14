package com.prac.cote.hash;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.NumberUtils;

@SpringBootTest
public class HIndex {

	@Test
	// @RepeatedTest(20)
	public void solution() {
		// int[] op = {3, 0, 6, 1, 5, 3};
		int[] op = {0,1,1,1,3,5,6};

		Random random = new Random();

		int[] testCase = random.ints(1000, 0, 10000).toArray();

		List<Integer> list = Arrays.stream(op).boxed().collect(Collectors.toList());

		list.sort(Collections.reverseOrder());

		List<Integer> nonmoon = IntStream.rangeClosed(1, op.length)
			.boxed()
			.collect(Collectors.toList());

		int hIndex = list.size();

		for(int i = 0; i < list.size(); i++) {
			if(nonmoon.get(i).intValue() == list.get(i).intValue()) {
				hIndex = nonmoon.get(i);
				break;
			}
			if(nonmoon.get(i) > list.get(i)) {
				if(i == 0) {
					hIndex = 0;
				}else {
					hIndex = nonmoon.get(i-1).intValue();

				}
				break;
			}
		}
		System.out.println(hIndex);

	}
}
