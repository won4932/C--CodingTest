package com.prac.cote.stringSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Back11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String S = br.readLine();

        var substr = new HashSet<String>();

        for(int i = 1; i < S.length()+1; i++) {
            for(int j = 0; j < S.length()-i+1; j++) {
                substr.add(S.substring(j, j+i));
            }
        }

        System.out.println(substr.size());

    }

}