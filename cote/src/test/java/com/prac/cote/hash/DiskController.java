package com.prac.cote.hash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DiskController {

	@Test
	public void solution() {
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

		// PriorityQueue<Map<Integer, Integer>> que = new PriorityQueue<>(new Comparator<Map<Integer, Integer>>() {
		// 	@Override
		// 	public int compare(Map<Integer, Integer> o1, Map<Integer, Integer> o2) {
		// 		return o1.values().stream().findFirst().get().intValue() > o2.values().stream().findFirst().get().intValue() ? 1 : -1;
		// 	}
		// });

		// Arrays.sort(jobs, new Comparator<int[]>() {
		// 	@Override
		// 	public int compare(int[] o1, int[] o2) {
		// 		return o1[1] - o2[1];
		// 	}
		// });
		//
		// int job = 0;
		//
		// int count = 0;
		//
		// for(int i = 0; i < jobs.length; i++) {
		// 	count += job - jobs[i][0] + jobs[i][1];
		// 	job += jobs[i][1];
		// }
		//
		// System.out.println(count/3);

		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

		PriorityQueue<int[]> processOrderQue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		int index = 0;

		int job = 0;

		int answer = 0;

		int count = 0;

		while(count < jobs.length) {

			while (index < jobs.length && jobs[index][0] <= job) {
				processOrderQue.add(jobs[index++]);
			}

			if(processOrderQue.isEmpty()) {
				job = jobs[index][0];
			}else {
				int[] processingJob = processOrderQue.poll();
				answer += processingJob[1] + job - processingJob[0];
				job += processingJob[1];
				count++;
			}

		}
		System.out.println(answer/jobs.length);

	}
}
