package com.prac.cote.class2;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back2609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st= new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int leastCommonMultiple = 0;

        for(int i = 1; i <= x && i <= y; i++) {
            if(x % i == 0 && y % i ==0) {
                leastCommonMultiple = i;
            }
        }

        System.out.println(leastCommonMultiple);
        System.out.println((x*y)/leastCommonMultiple);
    }
}