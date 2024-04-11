package com.prac.cote.stringSearch;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back2941 {
    static String N;

    static final String[] criatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = br.readLine();

        int count = 0;

        char ck = 0;

//        int i = N.length()-1;
//
//        int j = i - 1;
//
//
//        while(i >= 0) {
//            if(j >= 0) {
//
//            }else {
//                j++;
//            }
//        }

        for(int i = N.length()-1; i >= 0; i--) {
            char now = N.charAt(i);

            if(now == '=' || now == '-' || now == 'j') {
                int j = i - 1;

                if(j >= 0) {
                    String critriaCk = N.charAt(j) + "" + now;


                    for (String s : criatia) {
                        if(critriaCk.equals(s)) {
                            if(critriaCk.equals("z=") && j-1 >= 0) {
                                if((N.charAt(j-1) + critriaCk).equals("dz=")) {
                                    i--;
                                }
                            }
                            i--;
                            break;
                        }
                    }
                }
            }

            count++;
        }

        System.out.println(count);
    }
}