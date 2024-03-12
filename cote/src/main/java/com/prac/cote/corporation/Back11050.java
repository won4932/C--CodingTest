package com.prac.cote.corporation;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(factorial(N) / (factorial(K) * factorial(N-K)));
    }

    public static int factorial(int n) {
        if(n <= 1) {
            return 1;
        }

        return n * factorial(n-1);
    }
}