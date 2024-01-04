package com.prac.cote.class1;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back2577 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String ABC = String.valueOf(((long) A * B * C));

        int[] N = new int[10];

        for(int i = 0; i < ABC.length(); i++) {
            int ck = Integer.parseInt(String.valueOf(ABC.charAt(i)));

            N[ck]++;
        }

        for (int i : N) {
            System.out.println(i);
        }
    }
}