package com.prac.cote.etc;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class onstore240512 {

    static boolean[][] visited = new boolean[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

       String str = "2020-02-02 uid2 pid1";

       int[] room = new int[1001];

//       String[] ch = str.split(" ");

        var list= new ArrayList<Integer>();

        list.add(1);
        list.add(0);
        list.add(3);
        list.add(4);


        System.out.println(list.stream().filter(l -> l < 1).findFirst().get());



    }

}