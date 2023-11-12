package com.prac.cote.class2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1436 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1436.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int movie = 666;

        int count = 1;

        while(count != N) {
            movie++;
            if(String.valueOf(movie).contains("666")) {
                count++;
            }
        }

        System.out.println(movie);

    }
}