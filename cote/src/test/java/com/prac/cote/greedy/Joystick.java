package com.prac.cote.greedy;

import org.junit.jupiter.api.Test;

public class Joystick {

	@Test
	public void test() {
		String name = "JAN";
		// System.out.println((int)("Z".charAt(0)));

		int answer = 0;

		int move = name.length()-1;

		for(int i = 0; i < name.length(); i++) {
			answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
			if(i < name.length() -1 && name.charAt(i + 1) == 'A') {
				int aCk = i + 1;
				while (aCk < name.length() && name.charAt(aCk) == 'A') aCk++;
				move = Math.min(move, (name.length() - aCk)*2 + i);
				move = Math.min(move, i*2 + (name.length() - aCk));
			}
		}

		System.out.println(answer + move);

		// int ascii = 0;
		// int count = 0;
		//
		// boolean flag = false;
		//
		// int a = 0;
		// for(int i = 0; i < name.length(); i++) {
		// 	ascii = (int)name.charAt(i);
		//
		// 	System.out.println(name.charAt(i) + " : " + ascii);
		//
		// 	if(i != 0 && name.charAt(i-1) == 'A') {
		// 		flag = true;
		// 	}else {
		// 		flag = false;
		// 	}
		//
		// 	if(name.charAt(i) == 'A') {
		// 		if(flag) a++;
		// 		else a = 1;
		// 	}
		//
		// 	if(78-ascii > 0) {
		// 		count += ascii - 65;
		// 	}else {
		// 		count += 90 - ascii + 1;
		// 	}
		// 	count++;
		// }
		// System.out.println(count-a-1);

	}
}
