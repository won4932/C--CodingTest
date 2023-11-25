package com.prac.cote.class2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1929 {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1929.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i = M; i <= N; i++) {
            if(is_prime(i)) System.out.println(i);
        }
    }

    public static boolean is_prime(int n) {
        for(int j = 2; j < Math.sqrt(n); j++) {
            if(n % j == 0) {
                return false;
            }
        }

        return true;
    }
}