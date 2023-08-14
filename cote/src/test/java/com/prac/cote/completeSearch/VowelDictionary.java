package com.prac.cote.completeSearch;

import org.junit.jupiter.api.Test;

public class VowelDictionary {

	private char[] vowel = {'E', 'I', 'O', 'U'};

	@Test
	public void test() {
		String word = "EIO";

		int count = 0;

		for(int i = 0; i < word.length(); i++) {
			count++;
			if(word.charAt(i)=='A') continue;
			for(int j = 0; j < vowel.length; j++) {
				count += pow(i);
				if(word.charAt(i) == vowel[j]) {
					break;
				}

			}
		}
	}

	public int pow(int p) {
		int result = 1;
		for(int i = 4-p; i > 0; i--) {
			result += Math.pow(5, i);
		}

		return result;
	}
}
