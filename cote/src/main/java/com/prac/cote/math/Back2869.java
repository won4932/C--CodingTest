package com.prac.cote.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		//        	int result = 0;
		//        	int day = 0;
		//        	while(result < V) {
		//        		day++;
		//        		result+=A;
		//        		if(result>=V) break;
		//
		//        		result-=B;
		//        	}
		//
		int day = 1 + (((V-A)%(A-B) == 0 ? (V-A)/(A-B) : ((V-A)/(A-B)) + 1));
		bw.write(day + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}