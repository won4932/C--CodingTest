package com.prac.cote.class3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back1074 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1074.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int NPow = (int) Math.pow(2, N);

        find(NPow, r, c);

        System.out.println(count);

    }

    public static void find(int size, int r, int c) {
        if(size == 1) return;

        int halfSize = size/2;
        int area = size * size;

        if(r < halfSize && c < halfSize) {
            find(size/2, r, c);
        }else if(r < halfSize && c >= halfSize) {
            count += area / 4;
            find(size/2, r, c-halfSize);
        }else if(r >= halfSize && c < halfSize) {
            count += (area / 4) * 2;
            find(size/2, r-halfSize, c);
        }else {
            count += (area / 4) * 3;
            find(size/2, r-halfSize, c-halfSize);
        }
    }
}