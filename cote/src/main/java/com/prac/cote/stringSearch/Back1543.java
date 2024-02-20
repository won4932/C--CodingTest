package com.prac.cote.stringSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Back1543 {
    static String doc, word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        doc = br.readLine();
        word = br.readLine();

        int docL = doc.length();
        int wordL = word.length();

        int max = 0;

        for(int i = 0; i <= docL - wordL; i++) {
            int count = 0;
            if(doc.charAt(i) != word.charAt(0)) continue;
            for(int j = i; j <= docL - wordL; j++) {
                if(doc.substring(j, j + wordL).equals(word)) {
                    count++;
                    j = j + wordL -1;
                }
            }
            max = Math.max(max, count);
        }

        System.out.println(max);


    }
}