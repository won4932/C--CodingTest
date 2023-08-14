package com.prac.cote.completeSearch;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MockExam {

	private static final int[][] guMath = {{1, 2, 3, 4, 5}
		, {2, 1, 2, 3, 2, 4, 2, 5}
		, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

	@Test
	public void solution() {

		// int[] answer = {1,2,3,4,5};
		int[] answer = {1,3,2,4,2, 1,3,2,4,2};

		int max = 0;

		Map<Integer, Integer> student = new HashMap<>();

		List<Integer> list = new ArrayList<>();

		for(int i = 0; i < 3; i++) {
			int winner = grading(guMath[i], answer);
			student.put(i+1, winner);
			max = winner > max ? winner : max;
			System.out.println("MAX : "+  max);
		}

		for(Integer st : student.keySet()) {
			if(max==student.get(st)) list.add(st);
		}

		for (Integer integer : list) {
			System.out.println(integer);
		}

		list.stream().mapToInt(x -> x).toArray();
	}


	public int grading(int[] paper, int[] answer) {
		int count = 0;

		for(int i = 0; i < answer.length; i++) {
			int index = i % paper.length;

			if(answer[i]==paper[index]) {
				count++;
			}
		}

		return count;
	}
}
