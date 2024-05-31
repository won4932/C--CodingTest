package com.prac.cote.stringSearchGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Back5052 {

    static int T, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            var list = new ArrayList<String>();

            for(int j = 0; j < N; j++) {
                list.add(br.readLine());
            }

            Collections.sort(list);

            if(search(list)) {
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }


        }
    }

    private static boolean search(ArrayList<String> list) {
        for(int a = 0; a < N-1; a++) {
            if(list.get(a+1).startsWith(list.get(a))) {
                return true;
            }

        }

        return false;
    }
}