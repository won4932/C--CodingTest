package com.prac.cote.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HashBestAlbum {

	@Test
	public int[] solution(String[] genres, int[] plays) {
		int[] answer = {};

		Map<String, String> hash = new HashMap<>();

		Map<String, Integer> sum = new HashMap<>();

		Map<Integer, Integer> playMap = new HashMap<>();

		List<Integer> list = new ArrayList<>();

		for(int i = 0; i<genres.length; i++) {
			playMap.put(i, plays[i]);

			sum.put(genres[i], sum.getOrDefault(genres[i], 0) + plays[i]);
			if(hash.containsKey(genres[i])) {
				hash.put(genres[i], hash.get(genres[i]) + "," + i);
			}else {
				hash.put(genres[i], i + "");
			}
		}


		playMap.forEach((k, v) -> System.out.println(k + " : " + v));

		List<String> keyList = new ArrayList<>(sum.keySet());

		keyList.sort((s1, s2) -> sum.get(s2) - sum.get(s1));

		// keyList.forEach(s -> System.out.println(s));

		// answer = new int[keyList.size() * 2];

		for(String key : keyList) {

			// System.out.println(key);

			Integer[] seq = Arrays.stream(hash.get(key).split(","))
				.map(String::trim).mapToInt(Integer::parseInt)
				.boxed()
				.toArray(Integer[]::new);

			Arrays.sort(seq, Comparator.reverseOrder());

			for(int a = 0; a < seq.length; a++) {
				System.out.println(seq[a]);
				System.out.println(playMap.get(seq[a]));
				if(a>1) break;
				// System.out.println(Arrays
				//                    .asList(plays)
				//                    .indexOf(""));
				// System.out.println(seq[a] + " : " + i);
				list.add(seq[a]);
				// i++;
			}


		}

		answer = new int[list.size()];

		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
			answer[i] = list.get(i);
		}

		return answer;
	}

	@Test
	void wearTest() {
		List<Integer> list = new ArrayList<>();

		list.add(1);
		list.add(2);

		int a = 0;

		// list.stream()
		// 	.collect(Collectors.collectingAndThen(
		// 		Collectors.toList(), k -> System.out.println(k.forEach();)));

		// ;

	}

	private int count = 0;



	@Test
	void maxTest() {
		int[] arr = {1, 3, 5, 4, 5, 2, 1};

		List<Long> result = new ArrayList<>();

		int[] res = new int[100];

		int ch = arr.length;

		// int count = 0;

		Map<Integer, Long> hash = Arrays.stream(arr)
			.boxed()
			// .collect(Collectors.toMap(Collectors.reducing(0, (x, y) -> x+1), 1));
			.collect(Collectors.groupingBy(p -> p, Collectors.counting()));

		List<Integer> list = new ArrayList<>(hash.keySet());

		Collections.sort(list, Collections.reverseOrder());

		int keyIndex = 0;

		int arrInedex = 0;

		int key = list.get(keyIndex);;

		while (hash.get(list.get(list.size()-1)).intValue() > 0) {
			if(arrInedex > arr.length) arrInedex = 0;

			if(hash.get(key).intValue() == 0) keyIndex++;

			key = list.get(keyIndex);




		}

		// for(int j = 0; j < list.size(); j++) {
		// 	int end = arr.length;
		// 	int key = list.get(j);
		// 	for(int i = 0; i < arr.length; i++) {
		// 		System.out.println(i + " 번쨰 key : " + key);
		// 		System.out.println("key Count : " + hash.get(key).intValue());
		// 		if(hash.get(key).intValue() == 0 && j < list.size()) key = list.get(j+1);
		// 			System.out.println(i + " 번쨰 key : " + key);
		// 			if(arr[i] == key && hash.get(key) > 0L) {
		//
		// 					hash.put(key, hash.get(key)-1);
		// 				count++;
		// 				// result.add(i, count);
		// 				res[i] = count;
		// 			}
		// 	}
		// }

		// list.forEach(key -> {
		// 	for(int i = 0; i < arr.length; i++) {
		// 		if(arr[i] == key.intValue() && hash.get(key) > 0) {
		// 			if(hash.get(key) == 0)
		// 			hash.put(key, hash.get(key)-1);
		// 			count++;
		// 			// result.add(i, count);
		// 			res[i] = count;
		// 		}
		// 	}
		// });

		Arrays.stream(res)
			.filter(l -> l > 0)
			.forEach(c -> System.out.println(c));

		// result.stream()
		// 		.filter(l -> l > 0)
		// 	.forEach(c -> System.out.println(c));

		// result.forEach(k -> System.out.println(k));

		// System.out.println(Arrays.stream(arr).max().stream().findFirst());
	}
}
