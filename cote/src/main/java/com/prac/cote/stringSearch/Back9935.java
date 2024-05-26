package com.prac.cote.stringSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Back9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        String boom = br.readLine();

        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if(stack.size() >= boom.length()) {
                boolean flag = true;

                for(int j = 0; j < boom.length(); j++) {
                    if(stack.get(stack.size()-boom.length()+j) != boom.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    for(int j = 0; j < boom.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        for (Character c : stack) {
            sb.append(c);
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}