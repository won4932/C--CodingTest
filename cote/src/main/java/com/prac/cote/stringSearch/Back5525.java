package com.prac.cote.stringSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back5525 {
    static int N, M;

    static StringBuilder SN = new StringBuilder("IOI");

    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        M = Integer.parseInt(br.readLine());

        S = br.readLine();
        //
        // for(int i = 1; i < N; i++) {
        //     SN.append("OI");
        // }

        int count = 0;

        int pnCount = 0;

        for(int i = 1; i < M-1; i++) {
            if(S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                pnCount++;
                if(pnCount == N) {
                    if(S.charAt(i-(pnCount*2-1))=='I') count++;
                pnCount--;
                }
                i++;
            }else {
                pnCount = 0;
            }
        }

        // for(int i = 0; i < M - SN.length() + 1; i++) {
        //     if(SN.charAt(0) == S.charAt(i)) {
        //         if(SN.toString().equals(S.substring(i, SN.length() + i))) {
        //             count++;
        //             i++;
        //         }
        //     }
        // }

        // while((start = S.indexOf(SN.toString(), start)) != -1) {
        //     count++;
        //     start++;
        // }

        System.out.println(count);
    }
}