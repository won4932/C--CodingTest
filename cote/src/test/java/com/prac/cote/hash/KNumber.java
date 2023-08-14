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
public class KNumber {

	@Test
	public void solution() {
		int[][] commands = {{2, 5, 3}, {4, 4, 1},{1, 7, 3}};
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[] answer = {};

		answer = new int[commands.length];

		for(int i = 0; i < commands.length; i++) {
			int[] list = Arrays.copyOfRange(array,  commands[i][0]-1,commands[i][1]);
			Arrays.sort(list);

			answer[i] = list[commands[i][2]-1];


		}

		for (int i : answer) {
			System.out.println(i);
		}
	}

	void sort(int[] a, int left, int right){
		int pl = left;
		int pr = right;
		int x = a[(pl+pr)/2];

		do{
			while(a[pl] < x) pl++;
			while(a[pr] > x) pr--;
			if(pl <= pr){
				int temp = a[pl];
				a[pl] = a[pr];
				a[pr] = temp;
				pl++;
				pr--;
			}
		}while(pl <= pr);

		if(left < pr) sort(a, left, pr);
		if(right > pl) sort(a, pl, right);
	}
}
