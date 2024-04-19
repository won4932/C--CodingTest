package com.prac.cote.stringSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String S = br.readLine();

        var suffixArray = new String[S.length()+1];

        for(int i = 0; i <= S.length(); i++) {
            suffixArray[i] = S.substring(i, S.length());
        }

        Arrays.sort(suffixArray);

        for (String s : suffixArray) {
            System.out.println(s);
        }

    }

}