package com.prac.cote.class2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1181 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1181.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        String[] alpa = new String[N];

        for(int i = 0; i < N; i++) {
            alpa[i] = br.readLine();
        }

        Arrays.stream(alpa)
                .distinct()
                .sorted((o1, o2) -> {
            if(o1.length() < o2.length()) {
                return -1;
            }else if(o1.length() > o2.length()){
                return 1;
            }else {
                return o1.compareTo(o2);
            }
        }).forEach(System.out::println);
    }
}