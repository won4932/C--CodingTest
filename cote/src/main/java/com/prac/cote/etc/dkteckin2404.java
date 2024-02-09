package com.prac.cote.etc;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class dkteckin2404 {

    static boolean[][] visited = new boolean[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Pattern pattern = Pattern.compile("\\[(.*?)]");

        String str = "[200][http://naver.com][FX][2012-06-10 08:00:00]";

        Matcher matcher = pattern.matcher(str);

        while(matcher.find()) {
            System.out.println(matcher.group());
        }

        if(matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }
    }

}