package com.prac.cote.class2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1546 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1546.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        double[] av = new double[N];

        st = new StringTokenizer(br.readLine());

        double max = 0;

        double result = 0;

        for(int i = 0; i < N; i++) {
            int grade = Integer.parseInt(st.nextToken());
            max = Math.max(max, grade);

            av[i] = (double)grade;
        }

        for (double i : av) {
            result += (i/max) * 100;
//            System.out.println(result);
        }

        System.out.println(result/av.length);

    }
}