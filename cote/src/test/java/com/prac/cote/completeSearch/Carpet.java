package com.prac.cote.completeSearch;

import org.junit.jupiter.api.Test;

public class Carpet {
	@Test
	public void test() {
		int br = 10;
		int ye = 2;

		int x = 0;
		int y = 0;

		int sum = br+ye;
		int temp = sum/3;
		for(int i = 3; i <= temp; i++){
			if(sum%i == 0) {
				temp = sum/i;
				if(ye==(temp-2)*(i-2)) {
					x = temp;
					y = i;
					break;
				}
			}
		}

		System.out.println("x : " + x + ", y : " + y);
	}
}
