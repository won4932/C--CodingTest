package com.prac.cote.class1;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back2562 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<Integer, Integer> N = new HashMap<>();

        for(int i = 0; i < 9; i++) {
            int naturalNumber = Integer.parseInt(br.readLine());
           N.put(naturalNumber, i);
        }

        List<Integer> keySet = new ArrayList<>(N.keySet());

        keySet.sort((o1, o2) -> o2.compareTo(o1));

        int max = keySet.get(0);

        System.out.println(max);

        System.out.println(N.get(max) + 1);
    }
}