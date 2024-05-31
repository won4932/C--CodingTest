package com.prac.cote.stringSearchGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Back1786 {

    static String T, P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        T = br.readLine();
        P = br.readLine();

        int[] tab = jump();

        int idx = 0;

        int count = 0;

        for(int i = 0; i < T.length();  i++) {

            while(idx > 0 && T.charAt(i) != P.charAt(idx)) {
                idx = tab[idx-1];
            }

            if(T.charAt(i) == P.charAt(idx)) {
                if(idx == P.length()-1) {
                    sb.append(i-idx+1).append(" ");
                    count++;
                    idx = tab[idx];
                }else {
                    idx++;
                }
            }

        }

        System.out.println(count);
        System.out.println(sb);

    }

    private static int[] jump() {
        int[] tab = new int[P.length()];

        int idx = 0;
        for(int i = 1; i < P.length(); i++) {

            while(idx > 0 && P.charAt(i) != P.charAt(idx)) {
                idx = tab[idx-1];
            }

            if(P.charAt(i) == P.charAt(idx)) {
                tab[i] = ++idx;
            }
        }

        return tab;
    }
}