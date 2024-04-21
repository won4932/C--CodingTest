package com.prac.cote.stringSearch;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class Back10610 {
    static Integer[][] dp;

    static ArrayList<Integer> mirko;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        mirko  = br.readLine()
                .chars()
                .mapToObj(c -> Character.getNumericValue((char) c))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toCollection(ArrayList::new));

        int sum = mirko.stream().mapToInt(l -> l).sum();

        if(!mirko.contains(0) || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        for (Integer i : mirko) {
            sb.append(i);
        }

        System.out.println(sb);


    }

}