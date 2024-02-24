package com.prac.cote.dp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        while(N > 0) {
            if((N % 5) == 0) {
                count += N / 5;
                System.out.println(count);
                return;
            }

            if(N < 3) {
                System.out.println("-1");
                return;
            }

            N-=3;
            count++;
        }

        System.out.println(count);

    }

    public static void dp(int N) {

    }
}