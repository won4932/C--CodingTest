package com.prac.cote.dp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class Back1029 {
    static int[][][] dpList;

    public static void main(String[] args) throws IOException {

        SpringApplication.run(Back1029.class, args);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        int[][] buy = new int[t][t];
        dpList = new int[t][1 << t][10];

        for (int a = 0; a < t; a++) {
            String str = reader.readLine();
            for (int b = 0; b < t; b++) {
                if(str.charAt(b) != '0') buy[a][b] = str.charAt(b) - '0';
            }
        }

        System.out.println(dp(0, 1 << (t -1), buy, 1, 0));
    }

    public static int dp(int celler, int mask, int[][] buy, int sum, int price) {
        int untilNowSum = sum;

        int compSum;

        if (dpList[celler][mask][price] != 0)
        {
            return dpList[celler][mask][price];
        }

        for (int c = 0; c < buy.length; c++) {
//            if ((mask & (1 << c -1)) != 0 || buy[celler][c] == 0 || buy[celler][c] < price) continue;
            if((mask | (1 << c -1)) != mask & buy[celler][c] >= price) {
                compSum = dp(c, mask | (1 << (c - 1)), buy, sum + 1, buy[celler][c]);
                if(untilNowSum < compSum) {
                    untilNowSum = compSum;
                }
            }

        }

        dpList[celler][mask][price] = untilNowSum;
        return untilNowSum;
    }
}