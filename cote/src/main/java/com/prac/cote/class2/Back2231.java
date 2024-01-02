package com.prac.cote.class2;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i < N; i++) {
            String is = String.valueOf(i);

            int lastDigit = 0;

            for(int j = 0; j < is.length(); j++) {
                lastDigit += Integer.parseInt(String.valueOf(is.charAt(j)));
            }

            int sum = i + lastDigit;

            if(N == sum) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }
}