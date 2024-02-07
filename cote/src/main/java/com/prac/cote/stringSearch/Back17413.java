package com.prac.cote.stringSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String S = br.readLine();

        var sk = new ArrayDeque<Character>();

        StringBuilder sb = new StringBuilder();

        boolean flag = false;

        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i)=='<') {
                flag = true;
            }


            if((S.charAt(i)==' ' && !flag) || (S.charAt(i)=='<' && !sk.isEmpty())) {
                while(!sk.isEmpty()) {
                    sb.append(sk.pop());
                }

                sb.append(S.charAt(i));
            }else if(S.charAt(i) == '>'){
                while(!sk.isEmpty()) {
                    sb.append(sk.pollLast());
                }

                sb.append('>');

                flag = false;
            }else {
                sk.push(S.charAt(i));
            }
        }

        while(!sk.isEmpty()) {
            sb.append(sk.pop());
        }

        System.out.println(sb);

    }

}