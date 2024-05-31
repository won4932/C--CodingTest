package com.prac.cote.etc;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

@SpringBootApplication
public class dkteckin2404 {

    static boolean[][] visited = new boolean[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Pattern pattern = Pattern.compile("\\[(.*?)]");

        String str = "[200][http://naver.com][FX][2012-06-10 08:00:00]";

        // Matcher matcher = pattern.matcher(str);
        //
        // while(matcher.find()) {
        //     System.out.println(matcher.group());
        // }
        //
        // if(matcher.find()) {
        //     System.out.println(matcher.group(1));
        //     System.out.println(matcher.group(2));
        //     System.out.println(matcher.group(3));
        // }

        // System.out.println(Integer.parseInt("000000000000000000000000000000100"));

        BigInteger big = new BigInteger("11");
        BigInteger big2 = new BigInteger("11");

        big = big.add(big2);

        // System.out.println(big.toString());
        //
        // IntStream.range(1, 5).forEach(i -> System.out.print(i + " "));

        // String a = "AAAAA";
        // String b = "ABCDEBBBB";
        //
        // for(int i = 0; i < b.length() - a.length() + 1; i++) {
        //     System.out.println(b.substring(i, a.length() + i));
        //
        // }

        System.out.println((int)Math.ceil((double)7 / 2));
    }

}