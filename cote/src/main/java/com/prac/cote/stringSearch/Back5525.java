package com.prac.cote.stringSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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

        for(int i = 1; i < N; i++) {
            SN.append("OI");
        }

        int start = 0;

        int count = 0;

        while((start = S.indexOf(SN.toString(), start)) != -1) {
            count++;
            start++;
        }

        System.out.println(count);
    }
}