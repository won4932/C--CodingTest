package com.prac.cote.stringSearch;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back1181 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        var set = new HashSet<String>();

        for(int i = 0; i < N; i++) {
            String word = br.readLine();

            set.add(word);
        }

        set.stream().sorted((o1, o2) -> {
            if(o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }else {
                return o1.compareTo(o2);
            }
        }).forEach(System.out::println);

    }
}