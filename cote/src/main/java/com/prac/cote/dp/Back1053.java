package com.prac.cote.dp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class Back1053 {

    static String[][] dp;

    public static void main(String[] args) throws IOException {

        SpringApplication.run(Back1053.class, args);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();

        int l = str.length();

        System.out.println(l);
        System.out.println(str.substring(0, l/2) + " " + str.substring(l/2+1, l));

        dp = new String[str.length()][];

//        dfs(0, str, l);

    }

    public static void dfs(int from, String str, int leng) {
        if(leng % 2 == 0) {
            if(str.substring(0, leng/2) == str.substring(leng/2, leng)) {
                return;
            }
        }else {
            if(str.substring(0, leng/2) == str.substring(leng/2+1, leng)) {
                return;
            }
        }



    }
}