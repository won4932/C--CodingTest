package com.prac.cote.dp;



import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1149 {

    static Integer[][] house;

    static int[][] dp;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        house = new Integer[N][3];
        dp = new int[N][3];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = house[0][0];
        dp[0][1] = house[0][1];
        dp[0][2] = house[0][2];

        int result = Integer.MAX_VALUE;

        for(int i = 0; i < 3; i++) {
            result = Math.min(result, dp(N -1, i));
//            int sum = house[0][i];
//            dp[0][0] = i;
//
//            for(int j = 1; j < N; j++) {
//                dp[j][1] = Integer.MAX_VALUE;
//                for(int a = 0; a < 3; a++) {
//                    if(a == dp[j-1][0]) continue;
//                    if(dp[j][1] > house[j][a]) {
//                        System.out.println(house[j][a]);
//                        dp[j][0] = a;
//                        dp[j][1] = house[j][a];
//                    }
//                }
//                sum+=dp[j][1];
//                System.out.println("SUM : " + sum);
//            }
//
//            result = Math.min(result, sum);
        }

        System.out.println(result);
//
//        System.out.println(result);

//        System.out.println(dp(N-1) % 10007);
    }

    public static int dp(int N, int i) {

        if(dp[N][i] == 0) {
            if(i == 0) {
                dp[N][0] = Math.min(dp(N-1, 1), dp(N-1, 2)) + house[N][0];
            }else if(i == 1) {
                dp[N][1] = Math.min(dp(N-1, 0), dp(N-1, 2)) + house[N][1];
            }else {
                dp[N][2] = Math.min(dp(N-1, 0), dp(N-1, 1)) + house[N][2];
            }
        }

        return dp[N][i];

    }
}