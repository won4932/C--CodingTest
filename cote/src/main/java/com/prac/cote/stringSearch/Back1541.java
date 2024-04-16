package com.prac.cote.stringSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Back1541 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String word = br.readLine();

        int sum = 0;

        N = word.length();

        int end = N;

        for(int i = N-1; i >= 0; i--) {
            if(word.charAt(i) == '-') {
                sum -= calc(word.substring(i+1, end));
                end = i;
            }
        }

        sum += calc(word.substring(0, end));

        System.out.println(sum);

    }

    public static int calc(String input) {
        int idx = input.indexOf("+");

        if(idx == -1) {
            return Integer.parseInt(input);
        }else {
            return calc(input.substring(0, idx)) + calc(input.substring(idx+1, input.length()));
        }
    }
}