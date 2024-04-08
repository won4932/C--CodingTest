package com.prac.cote.stringSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back9012 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String line = br.readLine();

            Stack<Character> sk = new Stack<>();

            for(int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);

                if(sk.isEmpty()) sk.push(c);
                else {
                    if(c == ')' && sk.peek() == '(') sk.pop();
                    else sk.push(c);
                }
            }

            if(sk.empty())
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}