package com.prac.cote.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class inputTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        var list = new ArrayList<String>();

        for(int i = 0 ; i < 3; i ++) {
            list.add(br.readLine());
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}