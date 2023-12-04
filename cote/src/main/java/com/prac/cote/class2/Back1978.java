package com.prac.cote.class2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1978 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

//        int[] ck = new int[1001];

        st = new StringTokenizer(br.readLine());

        int count = 0;

        boolean ck;

        for(int i = 0; i < N; i++) {
            int prime = Integer.parseInt(st.nextToken());

            if(prime == 1) continue;

            ck = true;

            for(int j = 2; j < Math.sqrt(prime); j++) {
                if(prime % j == 0) {
                    ck = false;
                    break;
                }
            }

            if(ck) count++;
        }

        System.out.println(count);
    }
}