package com.prac.cote.class2;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back2751 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

//        int[] q = new int[N];
        List<Integer> q =  new ArrayList<>();

        for(int i = 0; i < N; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(q);

        for (int i : q) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);

    }
}