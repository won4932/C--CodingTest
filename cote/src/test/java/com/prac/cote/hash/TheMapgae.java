package com.prac.cote.hash;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TheMapgae {

	@Test
	public void solution() {

		int[] sk = {1, 2, 3, 9, 10, 12};

		int K = 900;

		int count = 0;

		PriorityQueue<Integer> heap = new PriorityQueue<>();

		Arrays.stream(sk)
			.forEach(l -> heap.add(l));

		while(!heap.isEmpty()) {
			int first = heap.poll();

			if(first > K) break;

			if(heap.isEmpty()) {
				count++;
				break;
			}

			heap.add(first + (heap.poll() * 2));
			count++;

		}

		if(count == sk.length) count = -1;

		System.out.println(count);
	}
}
