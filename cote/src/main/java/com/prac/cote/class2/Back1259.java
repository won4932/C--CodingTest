package com.prac.cote.class2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back1259 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1259.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            String s = br.readLine();

            if(s.equals("0")) break;

            StringBuffer sb = new StringBuffer(s);

            if(s.equals(sb.reverse().toString())) {
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}