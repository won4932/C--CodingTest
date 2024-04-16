package com.prac.cote.stringSearch;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back1427 {
    static String N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = br.readLine();

        var words = new ArrayList<Integer>();

        for(int i = 0; i < N.length(); i++) {
            words.add(Integer.parseInt(String.valueOf(N.charAt(i))));
        }

        Collections.sort(words, Collections.reverseOrder());

        for (Integer word : words) {
            System.out.print(word);
        }
    }
}