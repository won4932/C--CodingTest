package com.prac.cote.class2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1676 {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1676.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int num = N;

        int count = 0;

        while(num >= 5) {
            count += num / 5;

            num /= 5;
        }

        System.out.println(count);

    }
}