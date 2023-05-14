package com.prac.cote.math;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back2941 {
	public static void main(String[] args){
		Scanner br = new Scanner(System.in);
		String alpet;
		String[] crotia = new String[] {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		alpet = br.nextLine();
		for (int i = 0; i < crotia.length; i++) {
			alpet = alpet.replace(crotia[i], "*");
		}
		System.out.println(alpet.length());
	}
}