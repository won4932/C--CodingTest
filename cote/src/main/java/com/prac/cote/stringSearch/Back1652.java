package com.prac.cote.stringSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Back1652 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int hCount = 0;
        int vCount = 0;

        String[] vertical = new String[N];
        String[] horizontal = new String[N];

        for(int i = 0; i < N; i++) {
            String row = br.readLine();
            horizontal[i] = row;
            for(int j = 0; j < N; j++) {
                char ch = row.charAt(j);
                if(vertical[j] == null) vertical[j] = String.valueOf(ch);
                else vertical[j] += row.charAt(j);
            }
        }

        for(int i = 0; i < N; i++) {
            vCount += search(vertical[i]);
            hCount += search(horizontal[i]);
        }

        System.out.println(hCount + " " + vCount);

    }

    private static int search(String attempt) {
        int count = 0;

        boolean ck = true;

        for(int j = 0; j < N-1; j++) {
            if(attempt.charAt(j) == 'X') {
                ck = true;
                continue;
            }

            if("..".equals(attempt.substring(j, j+2)) && ck) {
                count++;
                ck = false;
            }
        }

        return count;
    }
}