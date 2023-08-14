package com.prac.cote.dbfs;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class Network {

	static int count = 0;

	static boolean visit[] = new boolean[200];

	@Test
	public void test() {

		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

		dfs(0, 3, computers);

		System.out.println(count);
	}

	public void dfs(int depth, int n, int[][] computers) {

		if(depth == n-1) {
			count++;
			return;
		}

		IntStream.range(depth, computers.length)
				.forEach(i ->
					IntStream.range(0, computers[i].length)
						.filter(j -> j != i && j > 0 && visit[j] == false)
						.forEach(j -> {
							visit[depth] = true;
							dfs(depth+1, n, computers);
						}));
	}
}
