package com.prac.cote.stringSearch;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

@SpringBootApplication
public class Back5430 {
    static int T;

    static final Pattern pattern = Pattern.compile("\\d+");
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String command = br.readLine();
            int arrLength = Integer.parseInt(br.readLine());
//            String arr = br.readLine();
            st = new StringTokenizer(br.readLine(), "[],");
            ArrayDeque<Integer> deque = new ArrayDeque<>();

//            Matcher matcher = pattern.matcher(arr);
//
//            while(matcher.find()) {
//                deque.add(Integer.parseInt(matcher.group()));
//            }

            for(int b = 0 ; b < arrLength; b++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            AC(command, deque);

//            if(flag) {
//                System.out.print("[");
//                while(!deque.isEmpty()) {
//                    if(reverse) {
//                        System.out.print(deque.pollLast());
//                    }else {
//                        System.out.print(deque.poll());
//                    }
//
//                    if(!deque.isEmpty()) System.out.print(",");
//                }
//                System.out.print("]");
//            }else {
//                System.out.print("error");
//            }
//
//            System.out.println();

        }
        System.out.println(sb);
    }

    public static void AC(String command, ArrayDeque<Integer> deque) {
        boolean reverse = false;

        for(int j = 0; j < command.length(); j++) {
            if(command.charAt(j) == 'R') {
                reverse = !reverse;
            }else {
                if(deque.isEmpty()) {
//                    flag = false;
                    sb.append("error\n");
                    return;
                }
                if(reverse) {
                    deque.pollLast();
                }else {
                    deque.pollFirst();
                }
            }
        }

        printString(deque, reverse);
    }

    public static void printString(ArrayDeque<Integer> deque, boolean reverse) {
        sb.append('[');

        while(!deque.isEmpty()) {
            if(reverse) {
                sb.append(deque.pollLast());
            }else {
                sb.append(deque.poll());
            }

            if(!deque.isEmpty()) sb.append(',');
        }

        sb.append(']').append('\n');
    }
}