package com.prac.cote.completeSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LeastSquare {

	@Test
	public void solution() {
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

		List<Integer> max = new ArrayList<>();
		List<Integer> min = new ArrayList<>();

		for(int[] size : sizes) {
			max.add(Math.max(size[0], size[1]));
			min.add(Math.min(size[0], size[1]));
		}

		Integer v = max.stream().max(Comparator.comparing(x->x)).orElse(0);
		Integer h = min.stream().max(Comparator.comparing(x->x)).orElse(0);



		System.out.println(v * h);
	}
}
