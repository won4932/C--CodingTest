package com.prac.cote.stringSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Back1120 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        var books = new HashMap<String, Integer>();

        for(int i = 0; i < N; i++) {
            String book = br.readLine();
            books.put(book, books.getOrDefault(book, 0) +1);
        }

        var list = new LinkedList<>(books.entrySet());

        list.sort((o1, o2) -> {
            if(Objects.equals(o1.getValue(), o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }else {
                return o2.getValue() - o1.getValue();
            }
        });

        System.out.println(list.get(0).getKey());

    }
}