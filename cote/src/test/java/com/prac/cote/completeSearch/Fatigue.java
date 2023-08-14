package com.prac.cote.completeSearch;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Fatigue {

	static int max =  0;
	static boolean[] ck;

	@Test
	public void test() {
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};

		ck = new boolean[dungeons.length];

		dfs(dungeons, 0, 0, k, null);
	}

	public void dfs(int[][] dungeons, int depth, int count, int fatigue, int[] dun) {
		if(dun != null && fatigue >= dun[0]){
			fatigue -= dun[1];
			count++;
		}

		if(fatigue == 0 || depth==dungeons.length) {
			max = Math.max(max, count);
		}

		if(fatigue > 0) {

			for(int i = 0; i < dungeons.length; i++) {
				if(ck[i]) continue;
				ck[i] = true;

				if(ck[i]) {
					dfs(dungeons, depth+1, count, fatigue, dungeons[i]);
				}

				ck[i] = false;
			}
		}

	}
}
