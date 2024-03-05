package com.prac.cote.corporation;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        System.out.println(factorial(T));
    }

    public static int factorial(int n) {
        if(n <= 1) {
            return 1;
        }

        return n * factorial(n-1);
    }
}