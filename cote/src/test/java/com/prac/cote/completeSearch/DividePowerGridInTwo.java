package com.prac.cote.completeSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class DividePowerGridInTwo {

	static int[][] matrix;

	@Test
	void test() {
		int n = 7;
		// int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
		int[][] wires = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
		matrix = new int[n+1][n+1];

		int answer = n;
		// Map<Integer, List<Integer>> map = Arrays
		// 	.stream(wires)
		// 	.collect(Collectors.groupingBy(l -> l[0]
		// 		, Collectors.mapping(l -> l[1], Collectors.toList())))
		// 	;

		for (int i = 0; i < wires.length; i++) {
			matrix[wires[i][0]][wires[i][1]] = 1;
			matrix[wires[i][1]][wires[i][0]] = 1;
		}

		for (int i = 0; i < wires.length; i++) {
			int st = wires[i][0];
			int ed = wires[i][1];

			matrix[st][ed] = 0;
			matrix[ed][st] = 0;

			answer = Math.min(answer, dfs(n, st));

			matrix[st][ed] = 1;
			matrix[ed][st] = 1;
		}
		System.out.println(answer);
	}

	public int dfs(int n, int index) {
		boolean[] ck = new boolean[n+1];
		int cnt = 1;

		Queue<Integer> que = new LinkedList<>();
		que.offer(index);

		while (!que.isEmpty()) {
			int p = que.poll();
			ck[p] = true;

			for (int i = 1; i <= n; i++) {
				if (ck[i])
					continue;
				if (matrix[p][i] == 1) {
					que.offer(i);
					cnt++;
				}
			}
		}
		return (int)Math.abs(n - 2 * cnt);
	}
}

		// for(int i = 0; i < wires.length; i++) {
		// 	if(ck[i]) continue;
		// 	ck[i] = true;
		// 	if(ck[i] && wires[i][0]==wire[1] || wires[i][1]==wire[1]) {
		// 		System.out.println(wire[0] + ", " + wire[1] + " -> " + wires[i][0] + ", " + wires[i][1]);
		// 		count = dfs(wires, wires[i], count+1);
		//
		// 	}
		// 	ck[i] = false;
		// }
