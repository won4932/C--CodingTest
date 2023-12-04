package com.prac.cote.class1;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootApplication
public class Back1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String alpa = br.readLine().toUpperCase();

        int[] arr = new int[26];

        for(int i = 0; i < alpa.length(); i++) {
            if('A' <= alpa.charAt(i) && alpa.charAt(i) <= 'Z') {
                arr[alpa.charAt(i) - 'A']++;
            }
        }

        int max = -1;
        char ch = '?';

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                ch = (char)(i + 65);
            }
        }

        System.out.println(ch);
    }
}