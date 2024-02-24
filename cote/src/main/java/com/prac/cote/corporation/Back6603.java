package com.prac.cote.corporation;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back6603 {

    static int K = -1;
    static int[] aggregate;
    static int[] lotto;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        lotto = new int[6];

        while(true) {
            if(K == 0) break;
            st = new StringTokenizer(br.readLine());

            K = Integer.parseInt(st.nextToken());

            aggregate = new int[K + 1];

            for(int i = 0; i < K; i++) {
                aggregate[i] = Integer.parseInt(st.nextToken());
            }

            factorial(0, 0);

            System.out.println();
        }

    }

    public static void factorial(int x, int index) {
        if(index == 6) {
            for (int i : lotto) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = x; i < K; i++) {
            lotto[index] = aggregate[i];
            factorial(i+1, index+1);
        }
    }
}