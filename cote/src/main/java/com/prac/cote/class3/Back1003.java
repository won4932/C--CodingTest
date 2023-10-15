package com.prac.cote.class3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1003 {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1003.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int[] zero = new int[41];
        int[] one = new int[41];

        zero[0] = 1;
        zero[1] = 0;
        one[0] = 0;
        one[1] = 1;

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            for(int j = 2; j <= N; j++) {
                zero[j] = zero[j-1] + zero[j-2];
                one[j] = one[j-1] + one[j-2];
            }
            System.out.println(zero[N] + " " + one[N]);
        }

    }

}
