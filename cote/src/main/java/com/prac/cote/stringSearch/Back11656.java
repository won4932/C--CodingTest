package com.prac.cote.stringSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] aa = new int[2];

         String dasom = br.readLine();

         int[] reserved = dasom
             .chars()
             .map(c -> c - '0')
             .toArray();
        int check = -1;

        for(int i = 0; i < reserved.length; i++) {
            if(check != reserved[i]) {
                check = reserved[i];
                aa[reserved[i]]++;
            }
        }

        System.out.println(Math.min(aa[0], aa[1]));

        //     if(check != reserved[i]) {
        //         count++;
        //         int swap = check;
        //         check = reserved[i];
        //         reserved[i] = swap;
        //     }
        //
        // System.out.println(count);

    }

}