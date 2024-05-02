package com.prac.cote.stringSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Back1120 {
    static int N;

    static String A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        A = st.nextToken();
        B = st.nextToken();

        int result = Integer.MAX_VALUE;


        if(A.length() == B.length()) {
            result = Math.min(result, compareStr(A, B, 0));
        }else {
            int diff = Math.abs(A.length() - B.length());

            for(int i = 0; i <= diff; i++) {
                if(A.length() > B.length()) {
                    result = Math.min(result, compareStr(A, B, i));
                }else {
                    result = Math.min(result, compareStr(B, A, i));
                }
            }
        }

        System.out.println(result);


    }

    public static int compareStr(String longer, String shorter, int start) {
        int count = 0;
        for(int i = start; i < shorter.length()+start; i++) {
            if(longer.charAt(i) != shorter.charAt(i-start)) {
                count++;
            }
        }

//        System.out.println(count);

        return count;
    }
}