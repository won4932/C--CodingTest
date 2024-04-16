package com.prac.cote.stringSearch;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back5430 {
    static String N;

    static final String[] criatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            String str = br.readLine();

            if (!str.isEmpty() && str.charAt(0) == '.') break;

            var sk = new Stack<Character>();

            boolean flag = true;

            for (int i = str.length() - 1; i >= 0; i--) {
                if (str.charAt(i) == ')' || str.charAt(i) == ']') sk.push(str.charAt(i));
                else if (str.charAt(i) == '(') {
                    if (!sk.isEmpty()) {
                        if (sk.peek() == ')') sk.pop();
                        else flag = false;
                    } else {
                        flag = false;
                        break;
                    }

                } else if (str.charAt(i) == '[') {
                    if (!sk.isEmpty()) {
                        if (sk.peek() == ']') sk.pop();
                        else flag = false;
                    } else {
                        flag = false;
                        break;

                    }
                }
            }
            if (sk.isEmpty() && flag) System.out.println("yes");
            else System.out.println("no");
        }
    }
}