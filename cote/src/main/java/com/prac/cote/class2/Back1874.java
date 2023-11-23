package com.prac.cote.class2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back1874 {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1874.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int start = 0;

        while(N-- > 0) {
            int  v = Integer.parseInt(br.readLine());

            if(v > start) {
                for(int i = start +1; i <= v; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }

                start = v;
            } else if (stack.peek() != v) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);

    }
}