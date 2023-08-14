package com.prac.cote.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TwoOfPriorityQue {

	@Test
	public void solution() {
		String[] op = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		String[] op2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		PriorityQueue<Integer> maxPriorityQue = new PriorityQueue<>((o1, o2) -> o2 - o1);
		// PriorityQueue<Integer> minPriorityQue = new PriorityQueue<>();
		List<Integer> minList = new ArrayList<>();
		int[] array = new int[0];
		int[][] commands = null;
		array = new int[commands.length];


		Map<Integer, Integer> queCount = new HashMap<>();

		int[] answer = {};

		answer = new int[2];

		for (String s : op2) {
			String prefix = s.split(" ")[0];
			String value = s.split(" ")[1];

			if(prefix.equals("I")) {
				System.out.println("insert : " + value);
				minList.add(Integer.valueOf(value));
			}else {
				if(minList.isEmpty()) continue;
				Collections.sort(minList);
				if(value.equals("1")) {
					minList.remove((minList.size()-1));
				}else {
					minList.remove(0);
				}
			}
		}

		Collections.sort(minList);


		answer[1] = minList.isEmpty() ? 0 : minList.get(0);

		answer[0] = minList.isEmpty() ? 0 : minList.get(minList.size()-1);

		System.out.println(answer[0]);
		System.out.println(answer[1]);
		// System.out.println(minPriorityQue.poll());
		// for (String s : op) {
		// 	String prefix = s.split(" ")[0];
		// 	String value = s.split(" ")[1];
		//
		// 	if(prefix.equals("I")) {
		// 		maxPriorityQue.add(Integer.valueOf(value));
		// 		minPriorityQue.add(Integer.valueOf(value));
		// 	}else {
		// 		if(value.equals("1")) {
		// 			System.out.println(maxPriorityQue.peek());
		// 			maxPriorityQue.poll();
		// 		}else {
		// 			System.out.println(minPriorityQue.peek());
		// 			minPriorityQue.poll();
		// 		}
		// 	}
		// }

		// if(minPriorityQue.isEmpty() || maxPriorityQue.isEmpty()) {
		// 	answer[0] = 0;
		// 	answer[1] = 0;
		// }else {
		// 	answer[0] = minPriorityQue.poll();
		// 	answer[1] = maxPriorityQue.poll();
		// }
		//
		// System.out.println(answer[0]);
		// System.out.println(answer[1]);
	}
}
