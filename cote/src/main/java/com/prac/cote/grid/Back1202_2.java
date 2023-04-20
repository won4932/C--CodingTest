package com.prac.cote.grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back1202_2 {
    	static int result = 0;
    	static int[] bag;
    	static int[][] jewelry; // M, K
    	static int N, K;
    	public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		N = Integer.parseInt(st.nextToken());
    		K = Integer.parseInt(st.nextToken());
    		jewelry = new int[N][2];
    		bag = new int[K];


    		for(int i =0; i<N; i++) {
    			st = new StringTokenizer(br.readLine(), " ");
    			jewelry[i][0] = Integer.parseInt(st.nextToken()); // M
    			jewelry[i][1] = Integer.parseInt(st.nextToken()); // K
    		}
    		for(int i=0; i<K; i++) {
    			bag[i] = Integer.parseInt(br.readLine());
    		}
    		sort();
    		Arrays.sort(bag);
    //		for(int i=0; i<N; i++) {
    //			for(int j=0; j<2; j++) {
    //				System.out.print(jewelry[i][j] + " ");
    //			}
    //			System.out.println();
    //		}
    		stil();
    		System.out.println(result);
    	}
    	private static void sort() {
    		Arrays.sort(jewelry, new Comparator<int []>() {
    			public int compare(int[] o1, int[] o2) {
    				return Integer.compare(o1[0], o2[0]);
    			}
    		});
    	}
    	private static void stil() {
    		for(int i=0; i<K; i++) {
    			int max = 0;
    			int gemNumber = 0;
    			for(int j=0; j<N; j++) {
    				if(bag[i]>=jewelry[j][0]) {
    					if(max<jewelry[j][1]) {
    						gemNumber = j;
    						max = Math.max(max, jewelry[j][1]);
    					}
    				}
    			}

    			if(max==0) {
    				break;
    			}else {
    				result += max;
    				jewelry[gemNumber][1] = 0;
    			}
    		}
    	}
}