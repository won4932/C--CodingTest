package com.prac.cote.stringSearch;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back2941 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int count = 0;

        for(int i = 0; i < N; i++) {
            String word = br.readLine();

            var set = new HashSet<Character>();

            char sequenceCheck = 0;

            boolean check = true;

            for(int j = word.length()-1; j >= 0; j--) {
                char now = word.charAt(j);

                if(set.contains(now) && sequenceCheck != now) {
                    check = false;
                    continue;
                }else {
                    set.add(now);
                }

                sequenceCheck = now;
            }

            if(check) count++;
        }

        System.out.println(count);
    }
}