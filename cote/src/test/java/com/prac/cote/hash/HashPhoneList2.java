package com.prac.cote.hash;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HashPhoneList2 {

	@Test
	public boolean solution(String[] phone_book) {


		boolean answer = true;

		Arrays.sort(phone_book);

		for(int i = 0; i<phone_book.length-1; i++) {
			for(int j = i+1; j<phone_book.length; j++) {
				if(phone_book[j].substring(0, phone_book[i].length()).equals(phone_book[i])) {
					answer = false;
					break;
				}
			}
			if(!answer) break;
		}
		return answer;
	}
}
