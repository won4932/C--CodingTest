package com.prac.cote.class2;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class Back2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] statistics = new int[N];

        for(int i = 0; i < N; i++) {
            statistics[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(Math.round((float) Arrays.stream(statistics).sum() / N));

        Arrays.sort(statistics);

        System.out.println(statistics[N/2]);

        int count = 0;
        int max = -1;
        int mod = statistics[0];
        boolean check = false;
        //최빈값 구하는 반복문
        for(int i = 0; i < N - 1; i++) {
            if(statistics[i] == statistics[i + 1]) {
                count++;
            }else {
                count = 0;
            }

            if(max < count) {
                max = count;
                mod = statistics[i];
                check = true;
            }else if(max == count && check == true) {
                mod = statistics[i];
                check = false;
            }
        }

        System.out.println(mod);


        System.out.println(Arrays.stream(statistics).max().getAsInt() - Arrays.stream(statistics).min().getAsInt());
    }
}