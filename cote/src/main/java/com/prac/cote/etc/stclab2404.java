package com.prac.cote.etc;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

@SpringBootApplication
public class stclab2404 {

    static boolean[][] visited = new boolean[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<List<Integer>> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        Stack sk = new Stack<Integer>();

        for (List<Integer> integers : list) {

        }

        Set<Integer> set = new HashSet<>();

        IntStream.range(1, 55)
                .boxed()
                        .forEach(set::add);

        for (Integer i : set) {
            
        }


        list.add(List.of(1, 2, 3, 4));
        list.add(List.of(5, 6, 7, 8));
        list.add(List.of(10, 11, 12, 13));

        list.sort(Collections.reverseOrder());

        list.sort(Collections.reverseOrder());

        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

}