package com.prac.cote.stringSearchGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1786_fail {

    static String T, P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        T = br.readLine();
        P = br.readLine();

        int jump = jump();

        int count = 0;

        for(int i = 0; i < T.length()-P.length()+1;  i += jump) {
            boolean ck = true;

            for(int j = 0; j < P.length(); j++){
                System.out.print(T.charAt(i+j) + " ");
                if(T.charAt(i+j) != P.charAt(j)) {
                    ck = false;
                    break;
                }
            }

            if(ck) {
                sb.append(i + 1).append(" ");
                count++;
            }
        }

        // System.out.println(count);
        // System.out.println(sb);
    }

    private static int jump() {
        int mid = P.length() / 2;

        StringBuilder sb = new StringBuilder();

        int idx = 1;


        for(int i = mid; i < P.length()-1; i++) {
            int start = i;
            int count = 0;

            for(int j = 0; j < P.length(); j++) {
                if(P.charAt(j) != P.charAt(start)) {
                    break;
                }
                start++;
                count++;
                if(sb.length() < count) sb.append(P.charAt(j));
            }

            if(count == sb.length()) idx = i;
        }

        System.out.println(idx);

        return idx;
    }
}