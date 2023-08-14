package com.prac.cote.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.logging.log4j.util.PropertySource;
import org.junit.jupiter.api.Test;

public class GymSuit {

	@Test
	public void test() {
		int n = 3;
		int[] lost = {4, 2};
		int[] reserve = {1};

		int count = n - lost.length;

		lost = Arrays.stream(lost).sorted().toArray();
		reserve = Arrays.stream(reserve).sorted().toArray();

		for(int i = 0; i < lost.length; i++) {
			for(int j = 0; j < reserve.length; j++) {
				if(lost[i] == reserve[j]) {
					lost[i] = -1;
					reserve[j] = -1;
					break;
				}

				if(lost[i] == reserve[j]-1 || lost[i] == reserve[j]+1) {
					reserve[j] = -1;
					count++;
					break;
				}
			}
		}

		System.out.println(count);
	}
}
